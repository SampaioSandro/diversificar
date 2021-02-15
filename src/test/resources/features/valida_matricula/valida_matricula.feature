Feature: Valida matriculas

  @Validar
  Scenario Outline: Validar matriculas liberadas para diversificacao de fundos
    Given eu seleciono o arquivo de massa "validamatricula"
    When que eu execute um "GET" do servico que valida matriculas com as informacoes do "<cenario>"
#    Then o response deve ter os seguintes detalhes:
#      | valida | mensagem |
#      | 'true' | ' '      |
    Examples:
      | cenario          |
      | MATRICULA_VALIDA |


