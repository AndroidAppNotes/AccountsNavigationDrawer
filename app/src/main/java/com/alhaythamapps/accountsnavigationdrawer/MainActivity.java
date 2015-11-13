package com.alhaythamapps.accountsnavigationdrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity implements AccountHeader.OnAccountHeaderListener {
    private TextView mTvName, mTvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvName = (TextView) findViewById(R.id.text_name);
        mTvEmail = (TextView) findViewById(R.id.text_email);

        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilderX()
                .withActivity(this)
                .withAccountHeader(R.layout.material_drawer_header_x)
                .withHeaderBackground(R.drawable.bg_header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Notes")
                                .withEmail("notes@accounts.com")
                                .withIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                                .withNameShown(true),
                        new ProfileDrawerItem().withName("Navigation")
                                .withEmail("navigation@accounts.com")
                                .withIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                                .withNameShown(true),
                        new ProfileDrawerItem().withName("Drawer")
                                .withEmail("drawer@accounts.com")
                                .withIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                                .withNameShown(true),
                        new ProfileDrawerItem().withName("Material")
                                .withEmail("material@accounts.com")
                                .withIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                                .withNameShown(true)
                )
                .withOnAccountHeaderListener(this)
                .build();

        new DrawerBuilder().withActivity(this)
                .withAccountHeader(headerResult)
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggle(false)
                .build();
    }

    @Override
    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
        profile.getName().applyTo(mTvName);
        profile.getEmail().applyTo(mTvEmail);

        return false;
    }
}
