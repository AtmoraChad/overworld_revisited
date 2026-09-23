package net.atmorachad.overworld_revisited.entity.variant;

public interface FoxEntityAccessor {

    int NORMAL = 0;
    int TIMBER = 1;
    int BLACK = 2;
    int BIRCH = 3;
    int CINNAMON = 4;

    int overworldRevisited$getFoxVariant();

    void overworldRevisited$setFoxVariant(int variant);
}