import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.FireworkMeta;

import net.askarian.MisterErwin.CTF.CTF;
import net.askarian.MisterErwin.CTF.API.Addons.Addon;
import net.askarian.MisterErwin.CTF.API.events.CTFMatchEndEvent;
import net.askarian.MisterErwin.CTF.API.events.CTFPostTickEvent;


public class FireWorks extends Addon implements Listener{
	
	private List<String> authors = new ArrayList<String>();
	private CTF plugin;
	private String wteam = "";
	
	@Override
	public String getName() {
		return "After_Game_FireWorks";
	}

	@Override
	public boolean useEvents() {
		return true;
	}

	@Override
	public String getVersion() {
		return "1";
	}

	@Override
	public List<String> getAuthors() {
		return this.authors;
	}

	@Override
	public void onEnable(CTF inheritance) {
		this.authors.add("MisterErwin");	
		this.plugin = inheritance;
	}

	@Override
	public void onDisable() {		
	}
	
	@EventHandler
	public void onPostTick(CTFPostTickEvent event){
//		plugin.log.info("Fired! " + event.getTime() + " => " + plugin.MM.Team);
		//Stop Spamming
		if ((event.getTime() % 2) != 0)
			return;
		
		if (plugin.MM.Team.equals("A")){
			for (String pn: plugin.tm.TeamA.keySet()){
				Player p = plugin.getServer().getPlayerExact(pn);
				if (p == null || !p.isOnline())
					continue;
				Firework f = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				FireworkMeta fm = f.getFireworkMeta();	
				 //Create our effect with this
	            FireworkEffect effect = FireworkEffect.builder().withColor(Color.RED).with(Type.BALL).trail(false).build();
	           
	            //Then apply the effect to the meta
	            fm.addEffect(effect);
	            
	            fm.setPower(0);
	            
	            f.setFireworkMeta(fm);
			}
			
		}else if (plugin.MM.Team.equals("B")){
			for (String pn: plugin.tm.TeamB.keySet()){
				Player p = plugin.getServer().getPlayerExact(pn);
				if (p == null || !p.isOnline())
					continue;
				Firework f = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				FireworkMeta fm = f.getFireworkMeta();	
				 //Create our effect with this
	            FireworkEffect effect = FireworkEffect.builder().withColor(Color.BLUE).withFade(Color.BLUE).with(Type.BALL).trail(false).build();
	           
	            //Then apply the effect to the meta
	            fm.addEffect(effect);
	            
	            fm.setPower(0);
	            
	            f.setFireworkMeta(fm);
			}
			
		}else{
			for (String pn: plugin.tm.TeamA.keySet()){
				Player p = plugin.getServer().getPlayerExact(pn);
				if (p == null || !p.isOnline())
					continue;
				Firework f = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				FireworkMeta fm = f.getFireworkMeta();	
				 //Create our effect with this
	            FireworkEffect effect = FireworkEffect.builder().withColor(Color.SILVER).withFade(Color.WHITE).with(Type.BALL).trail(false).build();
	           
	            //Then apply the effect to the meta
	            fm.addEffect(effect);
	            
	            fm.setPower(0);
	            
	            f.setFireworkMeta(fm);
			}
			for (String pn: plugin.tm.TeamB.keySet()){
				Player p = plugin.getServer().getPlayerExact(pn);
				if (p == null || !p.isOnline())
					continue;
				Firework f = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
				FireworkMeta fm = f.getFireworkMeta();	
				 //Create our effect with this
	            FireworkEffect effect = FireworkEffect.builder().withColor(Color.SILVER).withFade(Color.WHITE).with(Type.BALL).trail(false).build();
	           
	            //Then apply the effect to the meta
	            fm.addEffect(effect);
	            
	            fm.setPower(0);
	            
	            f.setFireworkMeta(fm);
			}
		}
	}

}
