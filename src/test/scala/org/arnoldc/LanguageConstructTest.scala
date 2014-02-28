package org.arnoldc

class LanguageConstructTest extends ArnoldGeneratorTest {

  it should "Ignore commented out print statements" in {
    val code = "IT'S SHOWTIME\n" +
      "HEY CHRISTMAS TREE var\n" +
      "YOU SET US UP 10\n" +
      "YOU'VE JUST BEEN ERASED TALK TO THE HAND var\n" +
      "GET TO THE CHOPPER var\n" +
      "HERE IS MY INVITATION 11\n" +
      "ENOUGH TALK\n"+
      "TALK TO THE HAND var\n"+
      "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("11\n")
  }

  it should "Ignore commented out simple if else statements" in {
    val code =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE vartrue\n" +
        "YOU SET US UP @NO PROBLEMO\n" +
        "YOU'VE JUST BEEN ERASED BECAUSE I'M GOING TO SAY PLEASE vartrue\n" +
        "TALK TO THE HAND \"this commented out if branch should NOT be reached\"\n" +
        "BULLSHIT\n" +
        "TALK TO THE HAND \"this commented out else branch should NOT be reached\"\n" +
        "YOU HAVE NO RESPECT FOR LOGIC\n" +
        "BECAUSE I'M GOING TO SAY PLEASE vartrue\n" +
        "TALK TO THE HAND \"this branch should be reached\"\n" +
        "BULLSHIT\n" +
        "TALK TO THE HAND \"this else branch should NOT be reached\"\n" +
        "YOU HAVE NO RESPECT FOR LOGIC\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("this branch should be reached\n")
  }

  it should "function when while loop executed once" in {
    val code =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE varfalse\n" +
        "YOU SET US UP @NO PROBLEMO\n" +
        "STICK AROUND varfalse\n" +
        "GET TO THE CHOPPER varfalse\n" +
        "HERE IS MY INVITATION @I LIED\n" +
        "ENOUGH TALK\n" +
        "TALK TO THE HAND \"while statement printed once\"\n" +
        "CHILL\n" +
        "YOU'VE JUST BEEN ERASED STICK AROUND varfalse\n" +
        "GET TO THE CHOPPER varfalse\n" +
        "HERE IS MY INVITATION @I LIED\n" +
        "ENOUGH TALK\n" +
        "TALK TO THE HAND \"while statement printed again\"\n" +
        "CHILL\n" +
        "YOU HAVE BEEN TERMINATED\n"
    getOutput(code) should equal("while statement printed once\n")
  }

  it should "Ignore commented out method invocations" in {
    val code =
      "IT'S SHOWTIME\n" +
        "HEY CHRISTMAS TREE argument\n" +
        "YOU SET US UP 123\n" +
        "DO IT NOW printInteger argument\n" +
        "YOU'VE JUST BEEN ERASED DO IT NOW printInteger argument\n" +
        "YOU HAVE BEEN TERMINATED\n" +
        "LISTEN TO ME VERY CAREFULLY printInteger\n" +
        "I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE value\n" +
        "TALK TO THE HAND value\n" +
        "HASTA LA VISTA, BABY"
    getOutput(code) should equal("123\n")
  }
}
