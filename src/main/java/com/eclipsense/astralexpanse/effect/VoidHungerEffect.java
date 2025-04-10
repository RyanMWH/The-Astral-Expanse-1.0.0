package com.eclipsense.astralexpanse.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class VoidHungerEffect extends MobEffect {
    private int tickcount;
    private float healControl;
    public VoidHungerEffect(MobEffectCategory category, int color) {
        super(category, color);
    }



    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        Level level1 = level;
        int radius = 5;
        AABB box = new AABB(entity.getX() - radius, entity.getY() - radius, entity.getZ() - radius,
                                 entity.getX() + radius, entity.getY() + radius, entity.getZ() + radius);



        List<LivingEntity> entities = level1.getEntitiesOfClass(LivingEntity.class, box, e -> e != entity);

        for (LivingEntity enemy : entities){
            if (tickcount % 20 == 0) {
                enemy.hurtServer(level, enemy.damageSources().magic(), 0.75F);
            }
        }

        if (tickcount % 20 == 0){
            // Heal depending on how many enemies around every 5 heals half a heart
            healControl = (float) entities.size() / 5;
            entity.heal(healControl);
        }



        tickcount += 1;

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
