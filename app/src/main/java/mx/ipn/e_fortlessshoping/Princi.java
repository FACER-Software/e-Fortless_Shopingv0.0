package mx.ipn.e_fortlessshoping;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
<<<<<<< Updated upstream

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
=======
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
>>>>>>> Stashed changes
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.estimote.mustard.rx_goodness.rx_requirements_wizard.Requirement;
import com.estimote.mustard.rx_goodness.rx_requirements_wizard.RequirementsWizardFactory;
import com.estimote.proximity_sdk.api.EstimoteCloudCredentials;
import com.estimote.proximity_sdk.api.ProximityObserver;
import com.estimote.proximity_sdk.api.ProximityObserverBuilder;
import com.estimote.proximity_sdk.api.ProximityZone;
import com.estimote.proximity_sdk.api.ProximityZoneBuilder;
import com.estimote.proximity_sdk.api.ProximityZoneContext;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mx.ipn.e_fortlessshoping.ui.ARCamera;
import mx.ipn.e_fortlessshoping.ui.Botonis;

public class Princi extends AppCompatActivity {

<<<<<<< Updated upstream
import mx.ipn.e_fortlessshoping.ui.HomeContentFragment1;

public class Princi extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawerLayout;
=======

    private AppBarConfiguration mAppBarConfiguration;
    private ProximityObserver proximityObserver;
    DrawerLayout drawer;


    Button Lacti, Papi, Fruti, Carni;
    NotificationCompat.Builder notificacion;
    private static final int id = 1;
    String channel_Id = "my_channel_01";

    Calendar calendar = Calendar.getInstance();
    Calendar calendari = new GregorianCalendar();
    int hora = calendari.get(Calendar.HOUR_OF_DAY);

    Botonis boton = new Botonis();

    String buenosLoches;
>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

<<<<<<< Updated upstream
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

=======

        Lacti = findViewById(R.id.Lacteos);

        Lacti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Fruti = findViewById(R.id.Frutas);
        Papi = findViewById(R.id.Paps);
        Carni = findViewById(R.id.Carnes);


        // TODO Estimote Beacons

        //Credenciales Deberia ponerlas como un String en el XML? TODO reflexionar
        EstimoteCloudCredentials cloudCredentials =
                new EstimoteCloudCredentials("e-fortless-shopping-6rc", "e44814f71c68ec621892cebad8846ffa");
        // Observador
        this.proximityObserver =
                new ProximityObserverBuilder(getApplicationContext(), cloudCredentials).
                        onError(new Function1<Throwable, Unit>() {
                            @Override
                            public Unit invoke(Throwable throwable) {
                                Log.e("app", "proximity Observer Error: " + throwable);
                                return null;
                            }
                        })
                        .withBalancedPowerMode().build();
        //Fin del Observador

        //Zonas de proximidad NOTA: Ahoria si viene lo chidoooo
        //Lacteos
        final ProximityZone Tienda = new ProximityZoneBuilder()
                .forTag("xD")
                .inCustomRange(1)
                .onContextChange(new Function1<Set<? extends ProximityZoneContext>, Unit>() {

                    @Override
                    public Unit invoke(Set<? extends ProximityZoneContext> Contexts) {

                        List<String> Zonas = new ArrayList<>();
                        for (ProximityZoneContext context : Contexts) {
                            Zonas.add(context.getAttachments().get("Zonas"));
                        }

                        Log.d("Zonas", Zonas + "");

                        int Tamaño = Zonas.size();
                        int Lacteos = 0;
                        int Frutas = 0;
                        int Carnes = 0;
                        int Papitas = 0;

                        for (int i = 0; i < Tamaño; i++) {
                            if (Zonas.get(i).equals("Lacteos")) {
                                Lacteos = 1;
                            }
                            if (Zonas.get(i).equals("Frutas")) {
                                Frutas = 1;
                            }
                            if (Zonas.get(i).equals("Carnes")) {
                                Carnes = 1;
                            }
                            if (Zonas.get(i).equals("Frituras")) {
                                Papitas = 1;
                            }

                        }

                        if (Lacteos == 1) {
                            Notificacion("Zona nueva",
                                    "Usted ha entrado a la zona de Lacteos",
                                    Color.WHITE);
                            Lacti.setVisibility(View.VISIBLE);
                            Lacti.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(new Intent(Princi.this, Lacteos.class));
                                }
                            });

                        }
                        if (Carnes == 1) {
                            Notificacion("Zona nueva",
                                    "Usted ha entrado a la zona de Carnes y Embutidos",
                                    Color.RED);
                            boton.setvCarnes(View.VISIBLE);

                            Carni.setVisibility(View.VISIBLE);
                            Carni.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(new Intent(Princi.this, Carnes.class));
                                }
                            });

                        }
                        if (Frutas == 1) {
                            Notificacion("Zona nueva",
                                    "Usted ha entrado a la zona de Frutas y Verduras",
                                    Color.GREEN);
                            boton.setvFrutas(View.VISIBLE);
                            Fruti.setVisibility(View.VISIBLE);

                            Fruti.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(new Intent(Princi.this, Frutas.class));
                                }
                            });

                        }
                        if (Papitas == 1) {
                            Notificacion("Zona nueva",
                                    "Usted ha entrado a la zona de Frituras y Confitería",
                                    Color.YELLOW);
                            boton.setvPapas(View.VISIBLE);
                            Papi.setVisibility(View.VISIBLE);

                            Papi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(new Intent(Princi.this, Frituras.class));
                                }
                            });

                        }
                        if (Lacteos == 0) {
                            Lacti.setVisibility(View.INVISIBLE);
                        }
                        if (Carnes == 0) {
                            Carni.setVisibility(View.INVISIBLE);
                        }
                        if (Frutas == 0) {
                            Fruti.setVisibility(View.INVISIBLE);
                        }
                        if (Papitas == 0) {
                            Papi.setVisibility(View.INVISIBLE);
                        }


                        return null;
                    }
                }).onExit(new Function1<ProximityZoneContext, Unit>() {
                    @Override
                    public Unit invoke(ProximityZoneContext proximityZoneContext) {
                        Notificacion("¡Hasta Luego! :D",
                                "Realizamos el cobro de sus productos, vuelva pronto",
                                Color.MAGENTA);
                        Log.d("Zonas", "Traiga el money");
                        return null;
                    }
                }).build();

        //Fin Lacteos

        // Fin logica de los BeACONS

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Boton flotante
>>>>>>> Stashed changes
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hola usuario", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
<<<<<<< Updated upstream

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/

=======
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
>>>>>>> Stashed changes
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

<<<<<<< Updated upstream
        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        drawerLayout.addDrawerListener(this);
=======
>>>>>>> Stashed changes

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_Principal, R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send, R.id.nav_Perfil, R.id.nav_CamaraRA,
                R.id.nav_Dieta)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

<<<<<<< Updated upstream
        View header = navigationView.getHeaderView(0);
            header.findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Princi.this, getString(R.string.title_click), Toast.LENGTH_SHORT).show();
                }
            });
=======
        navigationView.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentManager fragmentManager = getSupportFragmentManager();


                int id = menuItem.getItemId();
                if (id == R.id.nav_Principal) {
                    fragmentManager.beginTransaction().replace(R.id.Pincipalito, new Formulario()).commit();
                }
                if (id == R.id.nav_Perfil) {
                    fragmentManager.beginTransaction().replace(R.id.Pincipalito, new PerfilUsuario()).commit();
                }
                if (id == R.id.nav_CamaraRA) {
                    fragmentManager.beginTransaction().replace(R.id.Pincipalito, new ARCamera()).commit();
                }
                if (id == R.id.nav_Dieta) {
                    fragmentManager.beginTransaction().replace(R.id.Pincipalito, new Dietas()).commit();
                }
                if (id == R.id.nav_tools) {
                    fragmentManager.beginTransaction().replace(R.id.Pincipalito, new Herramientas()).commit();
                } else {

                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Pincipalito, new Formulario()).commit();

        //Auxiliares


        //Esto siempre va al final no le muevas we
        RequirementsWizardFactory
                .createEstimoteRequirementsWizard()
                .fulfillRequirements(this,
                        //onRequirementesFullfilled
                        new Function0<Unit>() {
                            @Override
                            public Unit invoke() {
                                Log.d("app", "requirements fulfilled");
                                proximityObserver.startObserving(Tienda);
                                return null;
                            }
                        },
                        //onRequirementsMissing
                        new Function1<List<? extends Requirement>, Unit>() {
                            @Override
                            public Unit invoke(List<? extends Requirement> requirements) {
                                Log.e("app", "requirements missing: " + requirements);
                                return null;
                            }
                        },
                        //OnError
                        new Function1<Throwable, Unit>() {
                            @Override
                            public Unit invoke(Throwable throwable) {
                                Log.e("app", "requirements error: " + throwable);
                                return null;
                            }
                        });
    }

    public void Notificacion(String title, String message, int colorsini) {
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);

        notificacion = new NotificationCompat.Builder(this, null);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = title;

            String description = message;
            int importances = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel(channel_Id, name, importances);

            channel.setDescription(description);
            channel.enableLights(true);

            channel.setLightColor(colorsini);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            notificationManager.createNotificationChannel(channel);

            notificacion = new NotificationCompat.Builder(this, channel_Id);
        }

        notificacion.setSmallIcon(R.drawable.ic_ensalada)
                .setContentTitle(title)
                .setContentText(message);

        notificacion.setChannelId(channel_Id);
        notificationManager.notify(id, notificacion.build());
>>>>>>> Stashed changes
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

<<<<<<< Updated upstream
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int title;
        switch (menuItem.getItemId()){
            case R.id.nav_Beacons:
                title = R.string.menu_share;
                break;
            case R.id.nav_CamaraRA:
                title = R.string.menu_gallery;
                break;
            case R.id.nav_Dieta:
                title = R.string.menu_send;
                break;
            case R.id.nav_QR:
                title = R.string.menu_slideshow;
                break;
            case R.id.nav_Principal:
                title = R.string.menu_home;
                break;
            case R.id.nav_tools:
                title = R.string.menu_tools;
                break;
            default:
                throw new  IllegalArgumentException("menu option not implemented!!");
        }

        Fragment fragment = HomeContentFragment1.newInstance(getString(title));
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_home, fragment).commit();

        setTitle(getString(title));

        //drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerClosed(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
=======

>>>>>>> Stashed changes
}

