package com.example.aisletest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.aisletest.repository.API;
import com.example.aisletest.repository.ApiCalls;
import com.example.aisletest.repository.PhoneVerificationResponse;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneNumberFragment extends Fragment {
    private String TAG = PhoneNumberFragment.class.getSimpleName();
private View globalView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.phone_number_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        globalView = view;
        view.findViewById(R.id.continue_phone_number).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View nView) {
//                NavHostFragment.findNavController(PhoneNumberFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                try {
                    ((Button) view.findViewById(R.id.continue_phone_number)).setEnabled(false);
                    login(((EditText) view.findViewById(R.id.country_code)).getText().toString() + ((EditText) view.findViewById(R.id.otp_et)).getText().toString());

                } catch (Exception e) {
                    ((Button) view.findViewById(R.id.continue_phone_number)).setEnabled(true);
                    e.printStackTrace();
                }
            }
        });


    }

    private void login(String number) {

        Log.d(TAG, number);
        ApiCalls apiCalls = API.getClient().create(ApiCalls.class);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), "{\n    \"number\": \"" + number + "\"\n}");
        Call<PhoneVerificationResponse> loginCall = apiCalls.login_using_phone(body, "__cfduid=df9b865983bd04a5de2cf5017994bbbc71618565720");
        loginCall.enqueue(new Callback<PhoneVerificationResponse>() {
            @Override
            public void onResponse(Call<PhoneVerificationResponse> call, Response<PhoneVerificationResponse> response) {
                if (response.isSuccessful()) {

                    if (response.body().isStatus()) {
                        NavHostFragment.findNavController(PhoneNumberFragment.this)
                                .navigate(R.id.action_FirstFragment_to_SecondFragment);
                    }
                }
            }

            @Override
            public void onFailure(Call<PhoneVerificationResponse> call, Throwable t) {
                Log.e(TAG, t.getMessage());
                ((Button) globalView.findViewById(R.id.continue_phone_number)).setEnabled(true);
            }
        });

    }
}