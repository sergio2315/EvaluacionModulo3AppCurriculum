package com.example.evaluacinmodulo3appcurriculum;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.evaluacinmodulo3appcurriculum.databinding.FragmentMessageBinding;


public class MessageFragment extends Fragment {
private FragmentMessageBinding binding;
    public MessageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentMessageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.buttonContact.setVisibility(view.GONE);
                binding.msgHolder.setVisibility(view.VISIBLE);
                binding.buttonSend.setVisibility(view.VISIBLE);
            }
        });
        binding.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.msgEt.getText().toString().length() != 0){
                    String message = binding.msgEt.getText().toString();
                    sendMessage(message);
                } else {
                    Toast.makeText(getContext(), "Debes ingresar un mensaje", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void sendMessage(String message) {
        Intent mIntent = new Intent(Intent.ACTION_SENDTO);
        mIntent.setData(Uri.parse("mailto:"));
        mIntent.putExtra(Intent.EXTRA_EMAIL, "sergiolillo2315@gmail.com");
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "Este es el asunto");
        mIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(mIntent);
    }
}