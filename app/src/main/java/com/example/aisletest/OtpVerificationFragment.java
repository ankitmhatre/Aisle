package com.example.aisletest;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;
        import androidx.navigation.fragment.NavHostFragment;

        import com.example.aisletest.repository.API;
        import com.example.aisletest.repository.ApiCalls;
        import com.example.aisletest.repository.OtpVerificationResponse;
        import com.example.aisletest.repository.PhoneVerificationResponse;

        import okhttp3.MediaType;
        import okhttp3.RequestBody;
        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class OtpVerificationFragment extends Fragment {
private View globalView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.otp_verifcation_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
globalView = view;


        view.findViewById(R.id.edit_number).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View nView) {
                NavHostFragment.findNavController(OtpVerificationFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.continue_otp_verify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View nView) {
                String num = ((TextView) view.findViewById(R.id.actual_number)).getText().toString();
                num = num.replaceAll(" ", "");

                ((Button) globalView.findViewById(R.id.continue_otp_verify)).setEnabled(false);
               verifyOtp(num, ((EditText) view.findViewById(R.id.otp_et)).getText().toString());

            }
        });
    }

    private void verifyOtp(String number, String otp) {
        ApiCalls apiCalls = API.getClient().create(ApiCalls.class);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), "{\n    \"number\": \"" + number + "\", \"otp\": \""+otp+"\"\n}");

        Call<OtpVerificationResponse> verifyCall = apiCalls.verifyOtp(body, "__cfduid=df9b865983bd04a5de2cf5017994bbbc71618565720");
verifyCall.enqueue(new Callback<OtpVerificationResponse>() {
    @Override
    public void onResponse(Call<OtpVerificationResponse> call, Response<OtpVerificationResponse> response) {
        if (response.isSuccessful()) {

            if (response.body().getToken() != null) {
                startActivity(new Intent(getActivity(), HomeActitvity.class));
//                NavHostFragment.findNavController(OtpVerificationFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            } else {
                ((Button) globalView.findViewById(R.id.continue_otp_verify)).setEnabled(true);
            }

        }
    }
    @Override
    public void onFailure(Call<OtpVerificationResponse> call, Throwable t) {
        ((Button) globalView.findViewById(R.id.continue_otp_verify)).setEnabled(true);
    }
});



        /**
         *  NavHostFragment.findNavController(OtpVerificationFragment.this)
         *                         .navigate(R.id.action_SecondFragment_to_FirstFragment);
         */
    }

}