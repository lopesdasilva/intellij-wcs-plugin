import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import configurations.WebCenterSitesPluginModuleConfigurationData;
import org.jetbrains.annotations.NotNull;

/**
 * Created by NB20308 on 28/12/2015.
 */
public class WebCenterSitesPlugin implements ProjectComponent {

    private final Project project;

    public WebCenterSitesPlugin(Project project) {
        this.project = project;
        csdt.Preferences.setProject(project);
    }


    @Override
    public void initComponent() {

        WebCenterSitesPluginModuleConfigurationData.setPluginActive(PropertiesComponent.getInstance().getBoolean("wcs-plugin-active"));
        if(PropertiesComponent.getInstance().getBoolean("wcs-plugin-active")) {
            WebCenterSitesPluginModuleConfigurationData.setInstance(PropertiesComponent.getInstance().getValue("wcs-instance"));
            WebCenterSitesPluginModuleConfigurationData.setModuleName(PropertiesComponent.getInstance().getValue("wcs-module-name"));
            WebCenterSitesPluginModuleConfigurationData.setUsername(PropertiesComponent.getInstance().getValue("wcs-username"));
            WebCenterSitesPluginModuleConfigurationData.setPassword(PropertiesComponent.getInstance().getValue("wcs-password"));
            WebCenterSitesPluginModuleConfigurationData.setContextPath(PropertiesComponent.getInstance().getValue("wcs-context-path"));
            WebCenterSitesPluginModuleConfigurationData.setWorkspace(PropertiesComponent.getInstance().getValue("wcs-workspace"));
            WebCenterSitesPluginModuleConfigurationData.setDataStoreName(PropertiesComponent.getInstance().getValue("wcs-datastore"));
        }
    }

    @Override
    public void disposeComponent() {
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "WebCenterSitesPlugin getComponentName";
    }

    @Override
    public void projectOpened() {
    }

    @Override
    public void projectClosed() {
    }
}