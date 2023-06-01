import java.util.Objects;

public class Calculator <T>{
    T operand1;
    T operand2;
    char operator;

    Calculator(T operand1, T operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public <T extends Number,U extends String> void calculate() {
//        if(this.operand1.getClass().getSimpleName().equalsIgnoreCase("Integer") && operand2.getClass().getSimpleName().equalsIgnoreCase("Integer")) {
//        if (operator instanceof Character)
//            throw  new InvalidTypeExceptoin("Invalid Operator");

        if(this.operand1 instanceof  Number && operand2 instanceof  Number) {
            double result = calculateBothInteger((T)operand1, (T)operand2, operator);
            System.out.println((operand1 instanceof  Number) +" "+result);
        }
        else if(operand1 instanceof String && operand2 instanceof String) {
            String result = calculateBothStrings((U)operand1, (U)operand2, operator);
            System.out.println("Both are string " +result );
        }

        else throw new InvalidTypeExceptoin("Type Not Matched with Other Operand");
    }

    private <T extends String> String calculateBothStrings(T operand1, T operand2, char operator) {
        String result = "";

        switch (operator) {
            case '+':
                return operand1.concat(operand2);

            default:
                throw new InvalidTypeExceptoin("Invalid Operator type");

        }


//        return result;
    }

    private <T extends Number> double calculateBothInteger(T operand1, T operand2, char operator) {
        if(operator == '+')
            return operand1.doubleValue()+operand2.doubleValue();
        else if(operator == '-')
            return operand1.doubleValue()-operand2.doubleValue();
        else if(operator == '*')
            return operand1.doubleValue()*operand2.doubleValue();
        else if(operator == '/') {
            if (operand2.doubleValue() == 0) throw new InvalidTypeExceptoin("Cannot divide by Zero");
            return operand1.doubleValue()/operand2.doubleValue();
        }
        else throw new InvalidTypeExceptoin("Operator Type not matched");
    }
}
