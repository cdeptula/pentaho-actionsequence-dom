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
 * Convenience class used to distinguish action inputs from action outputs.
 * @author Angelo Rodriguez
 *
 */
public class ActionOutput extends AbstractActionIOElement implements IActionInputVariable {

  public ActionOutput(Element ioElement, IActionParameterMgr actionInputProvider) {
    super(ioElement, actionInputProvider);
  }

  /**
   * @return the mapped name if it exists, otherwise the input/output name is returned.
   */
  public String getPublicName() {
    String mapping = getMapping();
    return ((mapping != null) && (mapping.trim().length() > 0)) ? mapping.trim() : ioElement.getName();
  }

  public String getVariableName() {
    return getPublicName();
  }
  
  public void setValue(Object value) {
    if (actionInputProvider != null) {
      actionInputProvider.setOutputValue(this, value);
    }
  }

  public Object getValue() {
    throw new UnsupportedOperationException();
  }
  
  public Boolean getBooleanValue() {
    throw new UnsupportedOperationException();
  }

  public Integer getIntValue() {
    throw new UnsupportedOperationException();
  }

  public String getStringValue() {
    throw new UnsupportedOperationException();
  }

  public String getStringValue(boolean replaceParamReferences) {
    throw new UnsupportedOperationException();
  }

  public boolean getBooleanValue(boolean defaultValue) {
    throw new UnsupportedOperationException();
  }

  public int getIntValue(int defaultValue) {
    throw new UnsupportedOperationException();
  }

  public String getStringValue(boolean replaceParamReferences, String defaultValue) {
    throw new UnsupportedOperationException();
  }

  public String getStringValue(String defaultValue) {
    throw new UnsupportedOperationException();
  }
}