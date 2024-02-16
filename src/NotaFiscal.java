import java.util.Iterator;
import java.util.List;

public class NotaFiscal {

    private String numeroNota;
    private List<Produto> produtos;

    public NotaFiscal(String numeroNota, List<Produto> produtos) {
        this.numeroNota = numeroNota;
        this.produtos = produtos;
    }
    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }

    public void removerProduto(String codigo) {
        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.codigo.equals(codigo)) {
                iterator.remove();
                break; //remove apenas um prodico com seu codigo
            }
        }
    }

    public double calcularValorProduto(String codigo){
        for (Produto produto : produtos){
            if (produto.codigo.equals(codigo)){
                return produto.precoUnitario * produto.quantidade;
            }
        }
        return 0;
    }

    public double calcuçarValorNotaFiscal(){
        double total = 0;
        for (Produto produto : produtos){
            total += produto.precoUnitario * produto.quantidade;

        }
        return total;
    }

}
