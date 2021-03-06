/**
 * Copyright (C) 2017 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mediadriver.atlas.validators.v2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by slepage on 3/15/17.
 */
public class PositiveIntegerValidatorTest {

    private PositiveIntegerValidator validator;

    private Errors errors;


    @Test
    public void supports() throws Exception {
        validator = new PositiveIntegerValidator("test.integer", "Integer must be >= 0");
        assertTrue(validator.supports(Integer.class));
        assertTrue(validator.supports(String.class));
    }

    @Test
    public void doesnot_supports() throws Exception {
        validator = new PositiveIntegerValidator("test.integer", "Integer must be >= 0");
        assertFalse(validator.supports(Boolean.class));
    }

    @Test
    public void validate() throws Exception {
        errors = new AtlasMappingErrors();
        validator = new PositiveIntegerValidator("test.integer", "Integer must be >= 0");
        validator.validate(0, errors);
        validator.validate(1222, errors);
        assertFalse(errors.hasErrors());
    }

    @Test
    public void validate_Invalid() throws Exception {
        errors = new AtlasMappingErrors();
        validator = new PositiveIntegerValidator("test.integer", "Integer must be >= 0");
        validator.validate(-1, errors);
        assertTrue(errors.hasErrors());
        assertThat(errors.getErrorCount(), is(1));
    }

    @Test
    public void validate_Invalid_Warn() throws Exception {
        errors = new AtlasMappingErrors();
        validator = new PositiveIntegerValidator("test.integer", "Integer must be >= 0");
        validator.validate(-1, errors, AtlasMappingError.Level.WARN);
        assertFalse(errors.hasErrors());
        assertTrue(errors.hasWarnings());
        assertThat(errors.getErrorCount(), is(1));
    }

    @Test
    public void validate_Invalid_Info() throws Exception {
        errors = new AtlasMappingErrors();
        validator = new PositiveIntegerValidator("test.integer", "Integer must be >= 0");
        validator.validate(-1, errors, AtlasMappingError.Level.INFO);
        assertFalse(errors.hasErrors());
        assertFalse(errors.hasWarnings());
        assertTrue(errors.hasInfos());
        assertThat(errors.getErrorCount(), is(1));
    }

    @Test
    public void validateWithErrorLevel() throws Exception {
        errors = new AtlasMappingErrors();
        validator = new PositiveIntegerValidator("test.integer", "Integer must be >= 0");
        validator.validate(0, errors, AtlasMappingError.Level.WARN);
        assertFalse(errors.hasErrors());
    }

}