package com.funProjects.mathriddles;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Integer.parseInt;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KeyboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KeyboardFragment extends Fragment implements View.OnClickListener {


    public KeyboardFragment() {
        // Required empty public constructor
    }


    public static KeyboardFragment newInstance() {
        KeyboardFragment fragment = new KeyboardFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_keyboard, container, false);
        Button zero = (Button) view.findViewById(R.id.number0button);
        zero.setOnClickListener(this);
        Button one = (Button) view.findViewById(R.id.number1button);
        one.setOnClickListener(this);
        Button two = (Button) view.findViewById(R.id.number2button);
        two.setOnClickListener(this);
        Button three = (Button) view.findViewById(R.id.number3button);
        three.setOnClickListener(this);
        Button four = (Button) view.findViewById(R.id.number4button);
        four.setOnClickListener(this);
        Button five = (Button) view.findViewById(R.id.number5button);
        five.setOnClickListener(this);
        Button six = (Button) view.findViewById(R.id.number6button);
        six.setOnClickListener(this);
        Button seven = (Button) view.findViewById(R.id.number7button);
        seven.setOnClickListener(this);
        Button eight = (Button) view.findViewById(R.id.number8button);
        eight.setOnClickListener(this);
        Button nine = (Button) view.findViewById(R.id.number9button);
        nine.setOnClickListener(this);
        Button enterbutton = (Button) view.findViewById(R.id.enterbutton);
        enterbutton.setOnClickListener(this);


        return  view;

    }

    @Override
    public void onClick(View v) {
        EditText answer = (EditText) getActivity().findViewById(R.id.answertext);
        switch (v.getId()){
            case R.id.number0button:
                answer.setText(answer.getText()+"0");
                break;
            case R.id.number1button:
                answer.setText(answer.getText()+"1");
                break;
            case R.id.number2button:
                answer.setText(answer.getText()+"2");
                break;
            case R.id.number3button:
                answer.setText(answer.getText()+"3");
                break;
            case R.id.number4button:
                answer.setText(answer.getText()+"4");
                break;
            case R.id.number5button:
                answer.setText(answer.getText()+"5");
                break;
            case R.id.number6button:
                answer.setText(answer.getText()+"6");
                break;
            case R.id.number7button:
                answer.setText(answer.getText()+"7");
                break;
            case R.id.number8button:
                answer.setText(answer.getText()+"8");
                break;
            case R.id.number9button:
                answer.setText(answer.getText()+"9");
                break;
            case R.id.enterbutton:
                try{
                    getAnswer(answer);
                    answer.setText("");
                }
                catch (NumberFormatException E) {
                    Log.e(getActivity().toString(),E.getStackTrace().toString());}

                break;

        }

    }

    private int getAnswer(EditText answer) throws NumberFormatException{
        return parseInt(answer.getText().toString());
    }
}
