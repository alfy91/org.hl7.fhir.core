package org.hl7.fhir.validation.cli.services;

import java.util.Set;
import java.util.function.Supplier;

import org.hl7.fhir.validation.ValidationEngine;

public interface SessionCache {

  /**
   * Stores the initialized {@link ValidationEngine} in the cache. Returns the session id that will be associated with
   * this instance.
   * @param validationEngine {@link ValidationEngine}
   * @return The {@link String} id associated with the stored instance.
   */
  String cacheSession(ValidationEngine validationEngine);

  /**
   * Uses the passed  {@link Supplier} to generate a {@link ValidationEngine} and add it to the cache. Returns the
   * session id that will be associated with the generated instance.
   * @param validationEngineSupplier {@link Supplier} of {@link ValidationEngine}
   * @return The {@link String} id associated with the stored instance.
   */
  String cacheSession(Supplier<ValidationEngine> validationEngineSupplier);

  /**
   * Stores the initialized {@link ValidationEngine} in the cache with the passed in id as the key. If a null key is
   * passed in, a new key is generated and returned.
   * @param sessionId The {@link String} key to associate with this stored {@link ValidationEngine}
   * @param validationEngine The {@link ValidationEngine} instance to cache.
   * @return The {@link String} id that will be associated with the stored {@link ValidationEngine}
   */
  String cacheSession(String sessionId, ValidationEngine validationEngine);

  /**
   * Checks if the passed in {@link String} id exists in the set of stored session id.
   * @param sessionId The {@link String} id to search for.
   * @return {@link Boolean#TRUE} if such id exists.
   */
  boolean sessionExists(String sessionId);

  /**
   * Removes the {@link ValidationEngine} associated with the passed in session id.
   * @param sessionId The {@link String} session id.
   * @return The {@link ValidationEngine} instance that was removed.
   */
  ValidationEngine removeSession(String sessionId);

  /**
   * Returns the stored {@link ValidationEngine} associated with the passed in session id, if one such instance exists.
   * @param sessionId The {@link String} session id.
   * @return The {@link ValidationEngine} associated with the passed in id, or null if none exists.
   */
  ValidationEngine fetchSessionValidatorEngine(String sessionId);

  /**
   * Returns the set of stored session ids.
   * @return {@link Set} of session ids.
   */
  Set<String> getSessionIds();
    
}