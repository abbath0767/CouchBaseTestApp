package com.luxary_team.couchbasetestapp.ui;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.luxary_team.couchbasetestapp.R;
import com.luxary_team.couchbasetestapp.data.model.Organization;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateOrganizationDialog extends Dialog implements View.OnClickListener {

    @BindView(R.id.edit_text_new_org_name)
    EditText mNameEditText;

    @BindView(R.id.edit_text_new_org_geo)
    EditText mGeoEditText;

    @BindView(R.id.edit_text_new_org_type)
    EditText mTypeEditText;

    @BindView(R.id.button_new_org_save)
    Button mSaveButton;

    @BindView(R.id.button_new_org_cancel)
    Button mCancelButton;

    private CreateOrgDialogListener mCreateOrgDialogListener;
    private Context mContext;
    private Organization mOrganization;

    public CreateOrganizationDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_create_organization);

        ButterKnife.bind(this);

        mCancelButton.setOnClickListener(this);
        mSaveButton.setOnClickListener(this);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onClick(View v) {
        if (v == mSaveButton) {
            createAndFillOrganization();
            mCreateOrgDialogListener.clickSave(mOrganization);
            dismiss();
        } else if (v == mCancelButton) {
            mCreateOrgDialogListener.clickCancel();
            dismiss();
        }
    }

    private void createAndFillOrganization() {
        mOrganization = new Organization();
        mOrganization.setName(mNameEditText.getText().toString());
        mOrganization.setGeo(Long.valueOf(mGeoEditText.getText().toString()));
        mOrganization.setIdType(Long.valueOf(mTypeEditText.getText().toString()));
        mOrganization.setType("organization");
    }

    public void setDialogClickListener(CreateOrgDialogListener listener) {
        mCreateOrgDialogListener = listener;
    }

    public interface CreateOrgDialogListener {
        void clickSave(Organization organization);
        void clickCancel();
    }
}
