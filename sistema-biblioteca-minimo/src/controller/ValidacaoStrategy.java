package controller;

// GoF Strategy: permite trocar a regra de validação.
@FunctionalInterface
public interface ValidacaoStrategy {
    void validar(String texto);
}
