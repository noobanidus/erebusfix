package noobanidus.mods.erebusfix;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber
@Mod(modid = ErebusFix.MODID, name = ErebusFix.MODNAME, version = ErebusFix.VERSION, dependencies = "required-after:erebus;")
@SuppressWarnings("WeakerAccess")
public class ErebusFix {
  public static final String MODID = "erebusfix";
  public static final String MODNAME = "Erebus Fix";
  public static final String VERSION = "GRADLE:VERSION";

  public static Logger LOG = LogManager.getLogger(MODID);

  public ErebusFix() {
  }

  @SuppressWarnings("unused")
  @Mod.Instance(ErebusFix.MODID)
  public static ErebusFix instance;
}
