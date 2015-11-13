package com.alhaythamapps.accountsnavigationdrawer;

import android.widget.TextView;

import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

/**
 * Created by alhaythamalfeel on 11/13/15.
 */
public class AccountHeaderBuilderX extends AccountHeaderBuilder {
    protected TextView mProfileFirstText;
    protected TextView mProfileSecondText;

    @Override
    protected void buildProfiles() {
        super.buildProfiles();

        if (mProfileFirstText == null) {
            mProfileFirstText = (TextView) mAccountHeader.findViewById(R.id.material_drawer_account_header_text_first);
        }

        if (mProfileSecondText == null) {
            mProfileSecondText = (TextView) mAccountHeader.findViewById(R.id.material_drawer_account_header_text_second);
        }

        setAccountName(mProfileFirstText, mProfileFirst);
        setAccountName(mProfileSecondText, mProfileSecond);
    }

    private void setAccountName(TextView tv, IProfile profile) {
        if (tv != null) {
            if (profile != null) {
                StringHolder.applyTo(profile.getName(), tv);
            } else {
                tv.setText(null);
            }
        }
    }
}
