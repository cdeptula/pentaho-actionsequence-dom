/*
 * Copyright 2006 Pentaho Corporation.  All rights reserved. 
 * This software was developed by Pentaho Corporation and is provided under the terms 
 * of the Mozilla Public License, Version 1.1, or any later version. You may not use 
 * this file except in compliance with the license. If you need a copy of the license, 
 * please go to http://www.mozilla.org/MPL/MPL-1.1.txt. The Original Code is the Pentaho 
 * BI Platform.  The Initial Developer is Pentaho Corporation.
 *
 * Software distributed under the Mozilla Public License is distributed on an "AS IS" 
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to 
 * the license for the specific language governing your rights and limitations.
*/
package org.pentaho.actionsequence.dom;

import org.dom4j.Element;
import org.pentaho.actionsequence.dom.actions.IActionParameterMgr;

/**
 * A wrapper class for an action if statement.
 * @author Angelo Rodriguez
 *
 */
public class ActionIfStatement extends ActionControlStatement {

  private static final ActionSequenceValidationError[] EMPTY_ARRAY = new ActionSequenceValidationError[0];
  public ActionIfStatement(Element controlElement, IActionParameterMgr actionInputProvider) {
    super(controlElement, actionInputProvider);
  }

  /**
   * Sets the if condition. The condition should be well formatted javascript.
   * @param condition the condition.
   */
  public void setCondition(String condition) {
    Element conditionElement = controlElement.element(ActionSequenceDocument.CONDITION_NAME);
    if (conditionElement == null) {
      conditionElement = controlElement.addElement(ActionSequenceDocument.CONDITION_NAME);
    }
    conditionElement.clearContent();
    conditionElement.addCDATA(condition);
    ActionSequenceDocument.fireControlStatementChanged(this);
  }
  
  /**
   * @return the condition.
   */
  public String getCondition() {
    String condition = ""; //$NON-NLS-1$
    Element conditionElement = controlElement.element(ActionSequenceDocument.CONDITION_NAME);
    if (conditionElement != null) {
      condition = conditionElement.getText();
    }
    return condition;
  }

  protected ActionSequenceValidationError[] validateThis() {
    return EMPTY_ARRAY;
  }
  
}