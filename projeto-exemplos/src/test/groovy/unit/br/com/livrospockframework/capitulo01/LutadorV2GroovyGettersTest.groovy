package unit.br.com.livrospockframework.capitulo01;

import br.com.livrospockframework.capitulo01.model.Lutador
import spock.lang.Specification

class LutadorV2GroovyGettersTest extends Specification {

	def 'deve criar um Lutador com a vida inicial padrão e'() {
		expect:
		new Lutador(1).vida != 0
	}

	def 'deve criar um Lutador com a vida inicial padrão w-t'() {
		when:
		def lutador = new Lutador(1)

		then:
		lutador.vida != 0
	}

	def 'deve aplicar golpe com a força certa'() {
		given:
		def forca = 20

		when:
		def lutador = new Lutador(forca)

		then:
		lutador.aplicarGolpe() == forca
	}

	def 'deve informar que lutador está nocauteado'() {
		given:
		def lutador = new Lutador(1)

		when:
		lutador.receberGolpe(lutador.vida)

		then:
		lutador.nocauteado
	}

	def 'deve informar que lutador não está nocauteado'() {
		given:
		def lutador = new Lutador(1)

		when:
		lutador.receberGolpe(lutador.vida - 1)

		then:
		!lutador.nocauteado
	}

	def 'deve reduzir a vida após receber golpe'() {
		given:
		def lutador = new Lutador(1)
		def vidaAntesGolpe = lutador.vida
		def forcaGolpeRecebido = 3

		when:
		lutador.receberGolpe(forcaGolpeRecebido)
		def vidaAposGolpe = vidaAntesGolpe - forcaGolpeRecebido

		then:
		lutador.vida == vidaAposGolpe
	}

	def 'deve ficar com a vida até 0 no minimo'() {
		given:
		def lutador = new Lutador(1)

		when:
		lutador.receberGolpe(lutador.vida + 1)

		then:
		lutador.vida == 0
	}
}
