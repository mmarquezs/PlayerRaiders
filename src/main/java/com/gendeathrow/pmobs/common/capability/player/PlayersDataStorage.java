package com.gendeathrow.pmobs.common.capability.player;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayersDataStorage implements IStorage<IPlayerData>
{
	private String lastDropPod = "lastDropPod";
	
    @Override
    public NBTBase writeNBT(Capability<IPlayerData> capability, IPlayerData instance, EnumFacing side)
    {
    	NBTTagCompound nbt = new NBTTagCompound();
    	
    	nbt.setLong(lastDropPod, instance.geLastDropPodCall());
    	
    	
        return nbt;
    }

    @Override
    public void readNBT(Capability<IPlayerData> capability, IPlayerData instance, EnumFacing side, NBTBase nbt)
    {
    	NBTTagCompound compound = (NBTTagCompound) nbt;
    	
         instance.setLastDropPodCall(compound.getLong(lastDropPod));  
       
    }
}