package net.minecraft.src;

import java.util.Random;

public class dc extends ay {

   public boolean a(World var1, Random var2, int var3, int var4, int var5) {
      byte var6 = 3;
      int var7 = var2.nextInt(2) + 2;
      int var8 = var2.nextInt(2) + 2;
      int var9 = 0;

      int var10;
      int var11;
      int var12;
      for(var10 = var3 - var7 - 1; var10 <= var3 + var7 + 1; ++var10) {
         for(var11 = var4 - 1; var11 <= var4 + var6 + 1; ++var11) {
            for(var12 = var5 - var8 - 1; var12 <= var5 + var8 + 1; ++var12) {
               Material var13 = var1.c(var10, var11, var12);
               if(var11 == var4 - 1 && !var13.a()) {
                  return false;
               }

               if(var11 == var4 + var6 + 1 && !var13.a()) {
                  return false;
               }

               if((var10 == var3 - var7 - 1 || var10 == var3 + var7 + 1 || var12 == var5 - var8 - 1 || var12 == var5 + var8 + 1) && var11 == var4 && var1.a(var10, var11, var12) == 0 && var1.a(var10, var11 + 1, var12) == 0) {
                  ++var9;
               }
            }
         }
      }

      if(var9 >= 1 && var9 <= 5) {
         for(var10 = var3 - var7 - 1; var10 <= var3 + var7 + 1; ++var10) {
            for(var11 = var4 + var6; var11 >= var4 - 1; --var11) {
               for(var12 = var5 - var8 - 1; var12 <= var5 + var8 + 1; ++var12) {
                  if(var10 != var3 - var7 - 1 && var11 != var4 - 1 && var12 != var5 - var8 - 1 && var10 != var3 + var7 + 1 && var11 != var4 + var6 + 1 && var12 != var5 + var8 + 1) {
                     var1.d(var10, var11, var12, 0);
                  } else if(var11 >= 0 && !var1.c(var10, var11 - 1, var12).a()) {
                     var1.d(var10, var11, var12, 0);
                  } else if(var1.c(var10, var11, var12).a()) {
                     if(var11 == var4 - 1 && var2.nextInt(4) != 0) {
                        var1.d(var10, var11, var12, Block.ao.ba);
                     } else {
                        var1.d(var10, var11, var12, Block.w.ba);
                     }
                  }
               }
            }
         }

         var10 = 0;

         while(var10 < 2) {
            var11 = 0;

            while(true) {
               if(var11 < 3) {
                  label204: {
                     var12 = var3 + var2.nextInt(var7 * 2 + 1) - var7;
                     int var14 = var5 + var2.nextInt(var8 * 2 + 1) - var8;
                     if(var1.a(var12, var4, var14) == 0) {
                        int var15 = 0;
                        if(var1.c(var12 - 1, var4, var14).a()) {
                           ++var15;
                        }

                        if(var1.c(var12 + 1, var4, var14).a()) {
                           ++var15;
                        }

                        if(var1.c(var12, var4, var14 - 1).a()) {
                           ++var15;
                        }

                        if(var1.c(var12, var4, var14 + 1).a()) {
                           ++var15;
                        }

                        if(var15 == 1) {
                           var1.d(var12, var4, var14, Block.au.ba);
                           gn var16 = (gn)var1.k(var12, var4, var14);

                           for(int var17 = 0; var17 < 8; ++var17) {
                              gc var18 = this.a(var2);
                              if(var18 != null) {
                                 var16.a(var2.nextInt(var16.a()), var18);
                              }
                           }
                           break label204;
                        }
                     }

                     ++var11;
                     continue;
                  }
               }

               ++var10;
               break;
            }
         }

         var1.d(var3, var4, var5, Block.as.ba);
         bm var19 = (bm)var1.k(var3, var4, var5);
         var19.f = this.b(var2);
         return true;
      } else {
         return false;
      }
   }

   private gc a(Random var1) {
      int var2 = var1.nextInt(11);
      return var2 == 0?new gc(en.ay):(var2 == 1?new gc(en.m, var1.nextInt(4) + 1):(var2 == 2?new gc(en.S):(var2 == 3?new gc(en.R, var1.nextInt(4) + 1):(var2 == 4?new gc(en.K, var1.nextInt(4) + 1):(var2 == 5?new gc(en.I, var1.nextInt(4) + 1):(var2 == 6?new gc(en.au):(var2 == 7 && var1.nextInt(100) == 0?new gc(en.ar):(var2 == 8 && var1.nextInt(2) == 0?new gc(en.aA, var1.nextInt(4) + 1):(var2 == 9 && var1.nextInt(10) == 0?new gc(en.c[en.aO.aQ + var1.nextInt(2)]):null)))))))));
   }

   private String b(Random var1) {
      int var2 = var1.nextInt(4);
      return var2 == 0?"Skeleton":(var2 == 1?"Zombie":(var2 == 2?"Zombie":(var2 == 3?"Spider":"")));
   }
}
