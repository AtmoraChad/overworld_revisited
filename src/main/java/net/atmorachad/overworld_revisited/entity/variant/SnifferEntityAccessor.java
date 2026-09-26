package net.atmorachad.overworld_revisited.entity.variant;


public interface SnifferEntityAccessor {

    int NORMAL = 0;
    int WARM = 1;
    int COLD = 2;

    int overworldRevisited$getSnifferVariant();

    void overworldRevisited$setSnifferVariant(int variant);
}