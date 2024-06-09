package br.com.alura.desafios;public class ConversorMoeda implements ConversaoFinanceira{
    @Override
    public Double converterDolarReal(Double valorDolar) {
        return valorDolar * 5.0;
    }
}
