/*
 * Copyright (C) 2010 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package com.sonar.csharp.parser.rules.expressions;

import static com.sonar.sslr.test.parser.ParserMatchers.notParse;
import static com.sonar.sslr.test.parser.ParserMatchers.parse;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.sonar.csharp.api.CSharpGrammar;
import com.sonar.csharp.parser.CSharpParser;

public class ArgumentTest {

  CSharpParser p = new CSharpParser();
  CSharpGrammar g = p.getGrammar();

  @Before
  public void init() {
    p.setRootRule(g.argument);
    g.argumentName.mock();
    g.argumentValue.mock();
  }

  @Test
  public void testOk() {
    assertThat(p, parse("argumentValue"));
    assertThat(p, parse("argumentName argumentValue"));
  }

  @Test
  public void testKo() throws Exception {
    assertThat(p, notParse(""));
  }

}
