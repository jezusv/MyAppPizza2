package com.example.jatuncar.myapppizza.Activities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jatuncar.myapppizza.Repositories.ComplementosCompra;
import com.example.jatuncar.myapppizza.Models.Compra;
import com.example.jatuncar.myapppizza.R;
import com.example.jatuncar.myapppizza.Models.TipoMasa;
import com.example.jatuncar.myapppizza.Repositories.TipoMasaRepository;
import com.example.jatuncar.myapppizza.Models.TipoPizza;
import com.example.jatuncar.myapppizza.Repositories.TipoPizzaRepository;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerTipoPizza;
    private RadioGroup rbt_group;
    private CheckBox chk_extra1;
    private CheckBox chk_extra2;
    private Button btn_ordenar;
    private TipoPizza TipoPizzaSel;
    private TipoMasa TipoMasaSel;
    private ComplementosCompra ComplementosAdd;
    private Integer Id_Compra = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instanciar todos los view
        spinnerTipoPizza = findViewById(R.id.sp_tipo_pizza);
        rbt_group = findViewById(R.id.rbt_group);
        btn_ordenar = findViewById(R.id.btn_ordenar);
        chk_extra1 = findViewById(R.id.chk_extra1);
        chk_extra2= findViewById(R.id.chk_extra2);
        //Asociar Eventos
        Spinner();
        Button();

    }
    private void Button()
    {
        btn_ordenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ordenar();
            }
        });
    }

    private void Ordenar()
    {
        try {
            ComplementosAdd = new ComplementosCompra();
            int radioButtonId =rbt_group.getCheckedRadioButtonId();
            if (radioButtonId == -1)
            {
                Toast.makeText(this, "Favor seleccionar Tipo de Masa!", Toast.LENGTH_LONG).show();
                return;
            }
           switch (radioButtonId)
           {
               case  R.id.rbt_masa1:
                   TipoMasaSel = (TipoMasaRepository.DevuelveTipoMasa(1));
                   break;
               case R.id.rbt_masa2:
                   TipoMasaSel = (TipoMasaRepository.DevuelveTipoMasa(2));
                   break;
               case R.id.rbt_masa3:
                   TipoMasaSel = (TipoMasaRepository.DevuelveTipoMasa(3));
                   break;
           }

            if (chk_extra1.isChecked()) {
                ComplementosAdd.ComplementosAdd(1);
            }
            if (chk_extra2.isChecked()) {
                ComplementosAdd.ComplementosAdd(2);
            }
            Compra orden = new Compra(Id_Compra,TipoPizzaSel,ComplementosAdd,TipoMasaSel);
            showMessageConfirmacionCompra(orden.MsgdeConfirmacionCompra());
            Id_Compra = Id_Compra + 1;
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void Spinner()
    {
        ArrayAdapter<TipoPizza> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, TipoPizzaRepository.tipoPizzas);
        spinnerTipoPizza.setAdapter(arrayAdapter);
        spinnerTipoPizza.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TipoPizzaSel =  ((TipoPizza)parent.getSelectedItem());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private void showMessageConfirmacionCompra(String msg)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Confirmación de pedido");
        alertDialog.setMessage(msg);
        alertDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showNotification();
            }
        },10000);
    }
    private void showNotification()
    {
        Notification notificacion = new NotificationCompat.Builder(this,"default")
                .setContentTitle("Pedido en camino")
                .setContentText("Tu pedido esta en camino")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = getSystemService(NotificationManager.class);

            // Se define un objecto NotificationChannel en Android 8
            NotificationChannel channel = new NotificationChannel("default",
                    "Channel name", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Channel description");
            notificationManager.createNotificationChannel(channel);

            notificationManager.notify(0, notificacion);
        }else{
            NotificationManager notificationManager = (NotificationManager)
                    this.getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(0, notificacion);
        }
    }
}

