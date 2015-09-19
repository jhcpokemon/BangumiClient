package io.github.jhcpokemon.bangumiclient.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import io.github.jhcpokemon.bangumiclient.R;

public class GetIdDialog extends DialogFragment {
    EditText editText;
    SharedPreferences sharedPreferences;
    public static final String USER_ID = "User_Id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getActivity().getPreferences(Context.MODE_APPEND);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_get_id, null);
        editText = (EditText) view.findViewById(R.id.intput_id_edit_text);
        builder.setView(view)
                .setNegativeButton(getString(R.string.negative_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        GetIdDialog.this.getDialog().dismiss();
                    }
                })
                .setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(USER_ID, editText.getText().toString());
                        editor.apply();
                        GetIdDialog.this.getDialog().dismiss();
                    }
                });
        return builder.create();
    }
}
