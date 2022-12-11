package com.example.newsapp;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

@GlideModule
public class MyglideApp extends AppGlideModule {
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }

}
