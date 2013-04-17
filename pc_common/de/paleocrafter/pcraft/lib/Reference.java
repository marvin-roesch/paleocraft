package de.paleocrafter.pcraft.lib;

public class Reference {
    /* General Mod related constants */
    public static final String MOD_ID = "PCraft";
    public static final String MOD_NAME = "PaleoCraft";
    public static final String VERSION_NUMBER = "@VERSION@ (build @BUILD_NUMBER@)";
    public static final String CHANNEL_NAME = MOD_ID;
    public static final String DEPENDENCIES = "required-after:Forge@[7.7.1.650,)";
    public static final String FINGERPRINT = "@FINGERPRINT@";
    public static final int SECOND_IN_TICKS = 20;
    public static final int SHIFTED_ID_RANGE_CORRECTION = 256;
    public static final String SERVER_PROXY_CLASS = "de.paleocrafter.pcraft.core.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "de.paleocrafter.pcraft.core.proxy.ClientProxy";
    public static final int VERSION_CHECK_ATTEMPTS = 3;
}
