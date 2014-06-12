/*
 * SonarQube, open source software quality management tool.
 * Copyright (C) 2008-2014 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * SonarQube is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * SonarQube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.batch.phases;

import org.apache.commons.lang.ClassUtils;
import org.sonar.api.BatchExtension;
import org.sonar.api.batch.InstantiationStrategy;
import org.sonar.api.batch.Sensor;
import org.sonar.batch.api.analyzer.Analyzer;
import org.sonar.batch.bootstrap.ExtensionMatcher;

/**
 * Allow to filter sensors that will be executed.
 * @since 3.6
 *
 */
@InstantiationStrategy(InstantiationStrategy.PER_BATCH)
public abstract class SensorMatcher implements BatchExtension, ExtensionMatcher {

  @Override
  public final boolean accept(Object extension) {
    return ClassUtils.isAssignable(extension.getClass(), Sensor.class)
      && acceptSensor((Sensor) extension) || ClassUtils.isAssignable(extension.getClass(), Analyzer.class);
  }

  public abstract boolean acceptSensor(Sensor sensor);

}
