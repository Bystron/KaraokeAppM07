package cat.itb.karaokeapp;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.schibsted.spain.barista.interaction.BaristaClickInteractions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import cat.itb.karaokeapp.activities.MainActivity;

import static com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn;
import static com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo;
import static com.schibsted.spain.barista.interaction.BaristaListInteractions.clickListItem;
import static com.schibsted.spain.barista.interaction.BaristaListInteractions.scrollListToPosition;

//Clase que contiene los tests de la aplicación.
//Ejecutar tests en orden, gracias.
@RunWith(AndroidJUnit4.class)
public class TestsApp {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void a_register_user() throws InterruptedException {

        clickOn(R.id.registerButton);
        writeTo(R.id.loginText, "Username");
        writeTo(R.id.passwordText, "password");
        writeTo(R.id.repeatPasswordText, "password");
        Random r = new Random();
        writeTo(R.id.emailText, "randomMail" + r.nextInt(100) +"@gmail.com");
        writeTo(R.id.nameText, "Name");
        writeTo(R.id.surnameText, "Surname");
        writeTo(R.id.birthDate, "15/08/2001");
        writeTo(R.id.menu, "Male");
        clickOn(R.id.acceptBox);
        clickOn(R.id.registerButton);
        Thread.sleep(1000);
        clickOn(R.id.logout);

    }


    @Test
    public void b_login_user() throws InterruptedException {

        clickOn(R.id.loginButton);
        writeTo(R.id.loginText, "a@gmail.com");
        writeTo(R.id.passwordText, "123456");
        clickOn(R.id.loginButton);
        Thread.sleep(1000);

    }

    @Test
    public void c_saved_songs_navigation_test() throws InterruptedException {

        Thread.sleep(1000);
        clickOn(R.id.playlist);
        scrollListToPosition(R.id.recyclerSaved, 9);

    }

    @Test
    public void d_song_navigation_test() throws InterruptedException {

        Thread.sleep(1000);
        clickListItem(R.id.recylcerViewPop, 2);
    }

    @Test
    public void e_search_song_navigation_test() throws InterruptedException {

        Thread.sleep(1000);
        clickOn(R.id.buscar);
        writeTo(R.id.searchBar, "Peaches");
        clickOn(R.id.searchButton);
        Thread.sleep(4000);
        scrollListToPosition(R.id.recyclerView, 4);
        clickListItem(R.id.recyclerView, 4);

    }

    @Test
    public void f_sing_a_song() throws InterruptedException {

        Thread.sleep(1000);
        scrollListToPosition(R.id.recylcerViewPop, 5);
        clickListItem(R.id.recylcerViewPop, 5);
        clickOn(R.id.btnPlay);

    }

    @Test
    public void g_log_out() throws InterruptedException {

        Thread.sleep(1000);
        clickOn(R.id.logout);

    }

}
