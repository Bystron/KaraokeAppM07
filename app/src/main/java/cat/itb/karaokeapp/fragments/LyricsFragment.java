package cat.itb.karaokeapp.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import cat.itb.karaokeapp.R;

//Clase que se encarga de enseñar y mostrar las letras y la canción.
public class LyricsFragment extends Fragment {

    TextView mTextStatus;
    ScrollView mScrollView;
    ImageButton button;
    SeekBar sBar;
    int cont;


    public LyricsFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_lyrics, container, false);

        cont = 0;

        mTextStatus = v.findViewById(R.id.lyrics);
        mScrollView = v.findViewById(R.id.scrollView2);
        button = v.findViewById(R.id.btnPlay);
        sBar = v.findViewById(R.id.sBar);

        MediaPlayer player = MediaPlayer.create(getActivity(), R.raw.samba);

        scrollToBottom();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!player.isPlaying()){

                    player.start();

                    button.setImageResource(R.drawable.outline_pause_black_24dp);
                }else{
                    player.pause();

                    button.setImageResource(R.drawable.playbtn);
                }

            }
        });

        return v;
    }

    //Método para bajar la letra de la canción automáticamente.
    private void scrollToBottom()
    {
        mScrollView.post(new Runnable()
        {
            public void run()
            {
                mScrollView.smoothScrollTo(0, mTextStatus.getBottom());
            }
        });
    }


}