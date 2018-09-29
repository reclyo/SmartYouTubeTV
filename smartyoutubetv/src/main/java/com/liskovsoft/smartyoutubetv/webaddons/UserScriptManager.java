package com.liskovsoft.smartyoutubetv.webaddons;

import android.content.Context;
import com.liskovsoft.smartyoutubetv.common.helpers.Helpers;

import java.io.InputStream;
import java.util.List;

public class UserScriptManager implements ScriptManager {
    private static final String ON_INIT_FOLDER = "on_init";
    private static final String ON_LOAD_FOLDER = "on_load";
    private static final String SCRIPTS_FOLDER = "scripts";
    private final Context mContext;
    private final List<String> mOnInitScripts;
    private final List<String> mOnLoadScripts;
    private final List<String> mStyles;

    public UserScriptManager(Context context) {
        mContext = context;
        mOnInitScripts = Helpers.listAssetFiles(mContext, SCRIPTS_FOLDER + "/" + ON_INIT_FOLDER, ".js");
        mOnLoadScripts = Helpers.listAssetFiles(mContext, SCRIPTS_FOLDER + "/" + ON_LOAD_FOLDER, ".js");
        mStyles = Helpers.listAssetFiles(mContext, SCRIPTS_FOLDER, ".css");
    }

    @Override
    public InputStream getOnInitScripts() {
        return Helpers.getSequenceResourceStream(mContext, mOnInitScripts);
    }

    @Override
    public InputStream getOnLoadScripts() {
        return Helpers.getSequenceResourceStream(mContext, mOnLoadScripts);
    }

    @Override
    public InputStream getStyles() {
        return Helpers.getSequenceResourceStream(mContext, mStyles);
    }
}
