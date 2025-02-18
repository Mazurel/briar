{ androidenv, ... }: androidenv.composeAndroidPackages {
  toolsVersion = "26.1.1";
  platformToolsVersion = "31.0.3";
  buildToolsVersions = [ "28.0.3" "30.0.3" ];
  platformVersions = [ "30" ];
  abiVersions = [ "armeabi-v7a" "arm64-v8a" ];
  cmakeVersions = [ "3.6.4111459" ];
  includeNDK = true;
  ndkVersions = [ "21.3.6528147" ];
  includeEmulator = false;
  includeSources = false;
  includeSystemImages = false;
  useGoogleAPIs = false;
  useGoogleTVAddOns = false;
}
