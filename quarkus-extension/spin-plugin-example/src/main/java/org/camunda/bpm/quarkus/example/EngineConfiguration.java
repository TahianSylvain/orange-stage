package org.camunda.bpm.quarkus.example;

import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.quarkus.engine.extension.QuarkusProcessEngineConfiguration;
import org.camunda.spin.plugin.impl.SpinProcessEnginePlugin;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EngineConfiguration extends QuarkusProcessEngineConfiguration {

  public EngineConfiguration() {
    List<ProcessEnginePlugin> plugins = new ArrayList<>();
    plugins.add(new SpinProcessEnginePlugin());
    setProcessEnginePlugins(plugins);
  }

}
