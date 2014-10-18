package com.cbedoy.apprende.viewcontroller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cbedoy.apprende.R;
import com.cbedoy.apprende.business.singup.interfaces.ISingupRepresentationDelegate;
import com.cbedoy.apprende.business.singup.interfaces.ISingupRepresentationHandler;
import com.cbedoy.apprende.interfaces.ICameraInformationDelegate;
import com.cbedoy.apprende.interfaces.ICameraInformationHandler;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Carlos on 14/10/2014.
 */
public class SingUpViewController extends AbstractViewController implements ISingupRepresentationHandler, ICameraInformationDelegate
{
    private CircleImageView circleImageView;
    private Button actionConfirm;
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private EditText firstName;
    private EditText lastName;
    private EditText facebook;
    private EditText twitter;
    private EditText age;

    private ISingupRepresentationDelegate singupRepresentationDelegate;
    private ICameraInformationHandler cameraInformationHandler;

    public void setSingupRepresentationDelegate(ISingupRepresentationDelegate singupRepresentationDelegate) {
        this.singupRepresentationDelegate = singupRepresentationDelegate;
    }

    public void setCameraInformationHandler(ICameraInformationHandler cameraInformationHandler) {
        this.cameraInformationHandler = cameraInformationHandler;
    }

    @Override
    protected View init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.app_singup_viewcontroller,  null);
        circleImageView = (CircleImageView) view.findViewById(R.id.app_singup_viewcontroller_avatar);
        actionConfirm = (Button) view.findViewById(R.id.app_singup_viewcontroller_confirm);
        username = (EditText) view.findViewById(R.id.app_singup_viewcontroller_username);
        email = (EditText) view.findViewById(R.id.app_singup_viewcontroller_email);
        password = (EditText) view.findViewById(R.id.app_singup_viewcontroller_password);
        confirmPassword = (EditText) view.findViewById(R.id.app_singup_viewcontroller_confirm_password);
        firstName = (EditText) view.findViewById(R.id.app_singup_viewcontroller_first_name);
        lastName = (EditText) view.findViewById(R.id.app_singup_viewcontroller_last_name);
        facebook = (EditText) view.findViewById(R.id.app_singup_viewcontroller_facebook);
        twitter = (EditText) view.findViewById(R.id.app_singup_viewcontroller_twitter);
        age = (EditText) view.findViewById(R.id.app_singup_viewcontroller_age);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraInformationHandler.userWantsShowCamera();
            }
        });
        actionConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    @Override
    public void reload() {

    }

    @Override
    public void showSingupView() {
        this.appViewManager.presentViewForTag(this.tag);
    }

    @Override
    public void clearInputs() {

    }

    @Override
    public void setPreviusImage(Bitmap bitmap) {
        circleImageView.setImageBitmap(bitmap);
    }
}