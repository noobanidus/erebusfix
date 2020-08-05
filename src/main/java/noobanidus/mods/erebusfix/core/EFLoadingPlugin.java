package noobanidus.mods.erebusfix.core;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.Name;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.SortingIndex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

@MCVersion(ForgeVersion.mcVersion)
@SortingIndex(-8000)
@Name("Uncrafting Blacklist Mixin Loading Plugin")
public class EFLoadingPlugin implements IFMLLoadingPlugin {
  public static Logger log = LogManager.getLogger("ErebusFix Core");

  public EFLoadingPlugin() {
    log.info("Attempting to bootstrap Mixins and plugins.");
    MixinBootstrap.init();
    Mixins.addConfiguration("mixins.loader.json");
  }

  @Override
  public String[] getASMTransformerClass() {
    return new String[0];
  }

  @Override
  public String getModContainerClass() {
    return null;
  }

  @Nullable
  @Override
  public String getSetupClass() {
    return null;
  }

  @Override
  public void injectData(Map<String, Object> data) {
  }

  @Override
  public String getAccessTransformerClass() {
    return null;
  }
}
