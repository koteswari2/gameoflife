package gameoflife;

import gameoflife.impl.SaschasGameOfLife1;
import org.fest.assertions.GenericAssert;

import java.util.Arrays;

public class GenerationAssert extends GenericAssert<GenerationAssert, SaschasGameOfLife1> {

    public GenerationAssert(SaschasGameOfLife1 actual) {
        super(GenerationAssert.class, actual);
    }

    public GenerationAssert hasDeadCellAt(int x, int y) {
        isNotNull();
        if (!actual.isCellAlive(x, y)) return myself;
        failIfCustomMessageIsSet();
        throw failure("Expected dead cell at ( " + x + " / " + y + " )");
    }

    public GenerationAssert hasLivingCellAt(int x, int y) {
        isNotNull();
        if (actual.isCellAlive(x, y)) return myself;
        failIfCustomMessageIsSet();
        throw failure("Expected living cell cell at ( " + x + " / " + y + " )");
    }

    public GenerationAssert hasCells(int... matrix) {
        isNotNull();
        final int[] actualMatrix = actual.toMatrix();
        if (Arrays.equals(actualMatrix, matrix)) return myself;
        failIfCustomMessageIsSet();
        throw failure("Next generation should be '" + Arrays.toString(matrix)  + " but is: " + Arrays.toString(actualMatrix) + "'.");
    }
}
