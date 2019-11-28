package com.sbt.javaschool.lesson7;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory, URLClassLoader urlClassLoader) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws Exception {
        File file = new File(pluginRootDirectory);

        File[] files = file.listFiles((dir, name) -> dir.isDirectory() && pluginName.equals(name));



        File classFile = files[0].listFiles(File::isFile)[0];
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{classFile.toURI().toURL()});

        Plugin plugin = (Plugin) urlClassLoader.loadClass(String.format(
                "com.sbt.javaschool.lesson7.pluginRootDirectory.%s.%s", pluginName, pluginClassName)).newInstance();
        plugin.doUsefull();
        return plugin;


    }
}
