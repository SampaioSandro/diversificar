Feature: Check on application status

  The `/api/status` end point returns a status message to indicate that the application is running successfully.

  @VerificarStatus
  Scenario: Application status end-point
    Given the application is running
    When I check the application status
    Then the API should return "ok"