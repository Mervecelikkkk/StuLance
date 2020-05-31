package com.example.stulance;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class MessagesFragment extends Fragment {

 private EditText m_etTo;
 private EditText m_etSub;
 private EditText m_etMessage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_messages, container, false);
       m_etTo=  v.findViewById(R.id.etTo);
       m_etSub=  v.findViewById(R.id.etSub);
       m_etMessage=  v.findViewById(R.id.etMessage);

        Button buttonSend=v.findViewById(R.id.btnSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

        return v;

    }

    private void sendMail(){

        String recipientList = m_etTo.getText().toString();
        String[] recipients = recipientList.split(",");
        String subject = m_etSub.getText().toString();
        String message = m_etMessage.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }

}
