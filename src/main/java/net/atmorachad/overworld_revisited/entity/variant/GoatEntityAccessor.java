package net.atmorachad.overworld_revisited.entity.variant;

public interface GoatEntityAccessor {

    int NORMAL = 0;
    int BLACK = 1;
    int BROWN = 2;

    int overworldRevisited$getGoatVariant();

    void overworldRevisited$setGoatVariant(int variant);
}