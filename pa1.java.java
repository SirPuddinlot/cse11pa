class PhysicsCalculator {
    int multiply (int x, int y) {
        return x * y;
    }
    int multiplyTest1 = multiply(12, 8);
    int multiplyTest1Exp = 96;
    int multiplyTest2 = multiply(-5, 4);
    int multiplyTest2Exp = -20;

    int square(int x) {
        return x * x;
    }
    int squareTest1 = square(3);
    int squareTest1Exp = 9;
    int squareTest2 = square(0);
    int squareTest2Exp = 0;

    int newton2(int mass, int accel) {
        return multiply(mass, accel);
    }
    int newton2Test1 = newton2(5, 2);
    int newton2Test1Exp = 10;
    int newton2Test2 = newton2(100, -3);
    int newton2Test2Exp = -300;

    int massEnergyEq(int mass, int c) {
        return multiply(mass, square(c));
    }
    int massEnergyEqTest1 = massEnergyEq(10, 512);
    int massEnergyEqTest1Exp = 2621440;
    int massEnergyEqTest2 = massEnergyEq(5, 100);
    int massEnergyEqTest2Exp = 50000;
}