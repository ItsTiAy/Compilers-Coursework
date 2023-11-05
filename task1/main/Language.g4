grammar Language;

prog
    : dec
    | dec prog
;
dec
    : type idfr LParen vardec RParen block # FunDecl
;
vardec
    :
    | vardecne
;
vardecne
    : type idfr
    | vardecne Comma type idfr
;
block
    : LBrace ene RBrace
;
ene
    : exp
    | exp Semicolon ene
;
exp
    : idfr                          # Id
    | intlit                        # Int
    | idfr Assign exp               # Asgmt
    | LParen exp binop exp RParen   # BinOpExpr
    | idfr LParen args RParen       # FunInvoc
    | block                         # Blk
    | If exp Then block Else block  # Ifstmt
    | While exp Do block            # WhileLoop
    | Repeat block Until exp        # RepeatLoop
    | Skip                          # Skip
;
args
    :
    | argsne
;
argsne
    : exp
    | argsne Comma exp
;
binop
    : Eq
    | Less
    | Gtr
    | LessEq
    | GtrEq
    | Plus
    | Minus
    | Times
    | Div
    | And
    | Or
    | Xor
;
type
    : IntType
    | BoolType
    | UnitType
;
idfr
    : Idfr
;
intlit
    : IntLit
;

Assign    : ':=' ;
Less      : '<' ;
LessEq    : '<=' ;
Plus      : '+' ;
Minus     : '-' ;
And       : '&&' ;
Xor       : '^^' ;
Eq        : '==' ;
Gtr       : '>' ;
GtrEq     : '>=' ;
Times     : '*' ;
Div       : '/' ;
Or        : '||' ;

LParen    : '(' ;
Comma     : ',' ;
RParen    : ')' ;
LBrace    : '{' ;
Semicolon : ';' ;
RBrace    : '}' ;

IntType   : 'int' ;
BoolType  : 'bool' ;
UnitType  : 'unit' ;

While     : 'while' ;
Do        : 'do' ;
Repeat    : 'repeat' ;
Until     : 'until' ;
If        : 'if' ;
Then      : 'then' ;
Else      : 'else' ;

Skip      : 'skip' ;

Idfr      : [a-z][A-Za-z0-9_]* ;
IntLit    : '0' | [1-9][0-9]* ;
WS        : [ \n\r\t]+ -> skip ;