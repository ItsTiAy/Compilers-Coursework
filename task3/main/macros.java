public class macros
{
    // loads the two numbers on the top of the stack into t1 and t2
    // uses the add keyword to add them together and puts the answer in t2
    // finally stores the answer in t2 onto the top of the stack
    public static String plus()
    {
        return """
                .macro Plus
                    lw      t1, 4(sp)
                    addi	sp, sp, 4
                    lw		t2, 4(sp)
                    addi	sp, sp, 4
                    add		t2, t1, t2
                    sw		t2, (sp)
                    addi	sp, sp, -4
                .end_macro
                """;
    }

    // the same as the plus method except the subtraction keyword is used instead
    public static String minus()
    {
        return """
                .macro Minus
                    lw      t1, 4(sp)
                    addi	sp, sp, 4
                    lw		t2, 4(sp)
                    addi	sp, sp, 4
                    sub		t2, t1, t2
                    sw		t2, (sp)
                    addi	sp, sp, -4
                .end_macro
                """;
    }

    // the same as the plus method except the multiply keyword is used instead
    public static String times()
    {
        return """
                .macro Times
                    lw      t1, 4(sp)
                    addi	sp, sp, 4
                    lw		t2, 4(sp)
                    addi	sp, sp, 4
                    mul		t2, t1, t2
                    sw		t2, (sp)
                    addi	sp, sp, -4
                .end_macro
                """;
    }

    // the same as the plus method except the divide keyword is used instead
    public static String divide()
    {
        return """
                .macro Divide
                    lw      t1, 4(sp)
                    addi	sp, sp, 4
                    lw		t2, 4(sp)
                    addi	sp, sp, 4
                    div		t2, t1, t2
                    sw		t2, (sp)
                    addi	sp, sp, -4
                .end_macro
                """;
    }

    // loads the two numbers on the top of the stack into t1 and t2.
    // if the values in t1 and t2 are the same, jumps to the isEq label using the branch if equal keyword.
    // Then t1 is loaded with the value 1 which is then put onto the top of the stack before branching to the endEq label.
    // if the values are not equal, t1 is loaded with the value 0 which is then put onto the top of the stack
    // and then branching to the endEq label

    public static String eq()
    {
        return """
                .macro Eq
                        lw      t1, 4(sp)
                        addi	sp, sp, 4
                        lw	    t2, 4(sp)
                        addi	sp, sp, 4
                        beq     t1, t2, isEq
                        li	    t1, 0
                        sw      t1, (sp)
                        addi	sp, sp, -4
                        b       endEq
                    isEq:
                    	li	    t1, 1
                        sw      t1, (sp)
                        addi	sp, sp, -4
                    endEq:
                .end_macro
                """;
    }

    // the same as the eq method but the branch if less than keyword is used instead
    public static String less()
    {
        return """
                .macro Less
                        lw      t1, 4(sp)
                        addi	sp, sp, 4
                        lw	    t2, 4(sp)
                        addi	sp, sp, 4
                        blt     t1, t2, isLess
                        li	    t1, 0
                        sw      t1, (sp)
                        addi	sp, sp, -4
                        b       endLess
                    isLess:
                    	li	    t1, 1
                        sw      t1, (sp)
                        addi	sp, sp, -4
                    endLess:
                .end_macro
                """;
    }

    // the same as the eq method but the branch if greater than keyword is used instead
    public static String gtr()
    {
        return """
                .macro Gtr
                        lw      t1, 4(sp)
                        addi	sp, sp, 4
                        lw	    t2, 4(sp)
                        addi	sp, sp, 4
                        bgt     t1, t2, isGtr
                        li	    t1, 0
                        sw      t1, (sp)
                        addi	sp, sp, -4
                        b       endGtr
                    isGtr:
                    	li	    t1, 1
                        sw      t1, (sp)
                        addi	sp, sp, -4
                    endGtr:
                .end_macro
                """;
    }

    // the same as the eq method but the branch if less than or equal keyword is used instead
    public static String lessEq()
    {
        return """
                .macro LessEq
                        lw      t1, 4(sp)
                        addi	sp, sp, 4
                        lw	    t2, 4(sp)
                        addi	sp, sp, 4
                        ble     t1, t2, isLessEq
                        li	    t1, 0
                        sw      t1, (sp)
                        addi	sp, sp, -4
                        b       endLessEq
                    isLessEq:
                    	li	    t1, 1
                        sw      t1, (sp)
                        addi	sp, sp, -4
                    endLessEq:
                .end_macro
                """;
    }

    // the same as the eq method but the branch if greater than or equal keyword is used instead
    public static String gtrEq()
    {
        return """
                .macro GtrEq
                        lw      t1, 4(sp)
                        addi	sp, sp, 4
                        lw	    t2, 4(sp)
                        addi	sp, sp, 4
                        bge     t1, t2, isGtrEq
                        li	    t1, 0
                        sw      t1, (sp)
                        addi	sp, sp, -4
                        b       endGtrEq
                    isGtrEq:
                    	li	    t1, 1
                        sw      t1, (sp)
                        addi	sp, sp, -4
                    endGtrEq:
                .end_macro
                """;
    }

    // loads the two numbers on the top of the stack into t1 and t2.
    // if the values in t1 and t2 are the same, jumps to the isSame label using the branch if equal keyword.
    // then it checks if one of the values is zero (meaning they both will be if true). If so, branches back to
    // twoZero label where top of stack is loaded with 0.
    // Otherwise, 1 is loaded onto the top of the stack.
    // If t1 and t2 are not equal in the first place, 0 is loaded onto the top of the stack.
    public static String and()
    {
        return """
                .macro  AndMac
                        lw      t1, 4(sp)
                        addi	sp, sp, 4
                        lw	    t2, 4(sp)
                        addi	sp, sp, 4
                        beq     t1, t2, isSame
                    twoZero:
                        li	    t1, 0
                        sw      t1, (sp)
                        addi	sp, sp, -4
                        b       endAnd
                    isSame:
                        beqz    t1, twoZero
                    	li	    t1, 1
                        sw      t1, (sp)
                        addi	sp, sp, -4
                    endAnd:
                .end_macro
                """;
    }

    // loads the two numbers on the top of the stack into t1 and t2.
    // checks t1, if it does not equal zero branches to isOr.
    // If it did equal zero, it then checks t2 and does the same.
    // If both t1 and t2 equal zero, 0 is loaded onto the top of the stack.
    // If either t1 or t2 were not 0, 1 is loaded onto the top of the stack.
    public static String or()
    {
        return """
                .macro OrMac
                        lw      t1, 4(sp)
                        addi	sp, sp, 4
                        lw	    t2, 4(sp)
                        addi	sp, sp, 4
                        bnez    t1, isOr
                        bnez    t2, isOr
                        li	    t1, 0
                        sw      t1, (sp)
                        addi	sp, sp, -4
                        b       endOr
                    isOr:
                        li	    t1, 1
                        sw      t1, (sp)
                        addi	sp, sp, -4
                    endOr:
                .end_macro
                """;
    }

    // loads the two numbers on the top of the stack into t1 and t2.
    // if t1 and t2 are the same, branches to areEq label where the stack is loaded with the value 0.
    // Otherwise if they are not equal, 1 is loaded onto the top of the stack.
    public static String xor()
    {
        return """
                .macro XorMac
                        lw      t1, 4(sp)
                        addi	sp, sp, 4
                        lw	    t2, 4(sp)
                        addi	sp, sp, 4
                        beq     t1, t2, areEq
                        li	    t1, 1
                        sw      t1, (sp)
                        addi	sp, sp, -4
                        b       endXor
                    areEq:
                    	li	    t1, 0
                        sw      t1, (sp)
                        addi	sp, sp, -4
                    endXor:
                .end_macro
                """;
    }

    // loads number that was the parameter into t1.
    // the value in t1 is then stored on the top of the stack.
    // the stack is then moved down.
    public static String pushImm()
    {
        return """
                .macro PushImm ($number)
                	li	    t1, $number
                	sw	    t1, (sp)
                	addi	sp, sp, -4
                .end_macro
                """;
    }

    // identifier value is loaded into t1 beforehand so then the value in t1 can be saved onto the top of the stack.
    // the stack is then moved down.
    public static String push()
    {
        return """
                .macro Push
                	sw	    t1, (sp)
                	addi	sp, sp, -4
                .end_macro
                """;
    }

    // sets the address of stack pointer into t0
    // saves the return address for the function to the top of stack and then moves the stack down
    // saves the contents of t0 back onto the stop of the stack and then moves the stack down
    // stores the address of the frame pointer onto the top of the stack
    // sets the frame pointer to the address of the stack pointer and then moves the stack down
    public static String savePointers()
    {
        return """
                .macro SavePointers
                    mv      t0 sp
                    
                    sw      ra (sp)
                    addi    sp sp -4
                    
                    sw      t0 (sp)
                    addi    sp sp -4
                    
                    sw      fp (sp)
                    mv      fp sp
                    addi    sp sp -4
                .end_macro
                """;
    }

    // sets the stack pointer to be one above the frame pointer
    // sets the frame pointer to the contents of the frame pointer
    // sets the return address to the contents of the top of the stack
    public static String restorePointers()
    {
        return """
                .macro RestorePointers
                    lw      sp 4(fp)
                    lw      fp (fp)
                    lw      ra (sp)
                .end_macro
                """;
    }
}
