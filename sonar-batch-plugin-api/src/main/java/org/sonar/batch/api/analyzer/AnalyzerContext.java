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
package org.sonar.batch.api.analyzer;

import org.sonar.api.batch.fs.InputFile;
import org.sonar.batch.api.analyzer.issue.AnalyzerIssue;
import org.sonar.batch.api.analyzer.measure.AnalyzerMeasure;
import org.sonar.batch.api.measures.Metric;

import javax.annotation.CheckForNull;

import java.io.Serializable;
import java.util.Collection;

/**
 * @since 4.4
 */
public interface AnalyzerContext {

  // ----------- MEASURES --------------

  /**
   * Find a project measure.
   */
  @CheckForNull
  AnalyzerMeasure<?> getMeasure(String metricKey);

  /**
   * Find a project measure.
   */
  @CheckForNull
  <G extends Serializable> AnalyzerMeasure<G> getMeasure(Metric<G> metric);

  /**
   * Find a file measure.
   */
  @CheckForNull
  AnalyzerMeasure<?> getMeasure(InputFile file, String metricKey);

  /**
   * Find a file measure.
   */
  @CheckForNull
  <G extends Serializable> AnalyzerMeasure<G> getMeasure(InputFile file, Metric<G> metric);

  /**
   * Add a measure.
   */
  void addMeasure(AnalyzerMeasure<?> measure);

  // ----------- ISSUES --------------

  /**
   * Add an issue.
   */
  void addIssue(AnalyzerIssue issue);

  /**
   * Add a list of issues.
   */
  void addIssues(Collection<AnalyzerIssue> issues);

}
