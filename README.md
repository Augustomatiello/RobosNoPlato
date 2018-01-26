# RobosNoPlato

1-Descrição

Resoução do problema dos robos que serão lançados em um platô em Marte pela NASA.

A descrição do problema segue:

Um grupo de robôs está prestes a ser lançado pela NASA em um platô em Marte. Este platô, que é curiosamente retangular, deve ser investigado pelos robôs de forma que suas câmeras on-board possam filmar o terreno e enviar os dados de volta para a Terra.

A posição de um robô e sua localização é representada por uma combinação de suas coordenadas x e y e uma letra representando um dos quatro pontos cardeais. O platô é organizado em um grid para simplificar a navegação. Um exemplo de posição pode ser "0 0 N" que indica que o robô está no canto inferior esquerdo do platô e voltado para o Norte.

Para controlar um robô, a NASA envia uma string simples de letras. As letras possíveis são E, D e A. E e D fazem o robô girar 90 graus para a Esquerda ou Direita respectivamente sem sair da posição atual. "A" faz o robô se deslocar 1 unidade para frente e manter a orientação atual.

Assuma que o quadrado diretamente ao norte de (x, y) é (x, y+1).

INPUT:
A primeira linha do input são as coordenadas do canto superior direito do platô. As coordenadas do canto inferior esquerdo são 0,0.

O resto do input são informações dos robôs lançados. Cada robô possui 2 linhas no input. A primeira linha dá a posição de lançamento do robô e a segunda linha uma série de instruções definindo o padrão de exploração do platô.

Cada robô executa seus movimentos de forma sequencial. O próximo robô não inicia seus movimentos até que o robô atual tenha finalizado o trabalho.

OUTPUT
O output de cada robô são suas coordenadas e orientação finais.

INPUT AND OUTPUT

Exemplo de Input:

5 5
1 2 N
EAEAEAEAA
3 3 L

AADAADADDA

Output Esperado:

1 3 N
5 1 L

2- Instruções

Para testar uma entrada, basta modificar o conteúdo arquivo exemplo.txt e rodar a classe main.
Os testes, em junit, verificam a validade do arquivo de entrada.
