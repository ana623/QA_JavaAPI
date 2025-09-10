<?xml version="1.0" encoding="UTF-8" ?>
<object class="Robot2" serializationversion="2">
  <prologue>
    <saved-by-versions>
      <version>11.5.0.7</version>
    </saved-by-versions>
    <file-type>robot2</file-type>
    <comment/>
    <icon/>
    <tags/>
    <typed-variables/>
    <parameters/>
    <requires-simple-input>false</requires-simple-input>
    <return-variables/>
    <store-in-database-variables/>
    <referenced-types/>
    <triggers/>
    <sub-robots/>
    <device-mappings>
      <mapping name="VM"/>
    </device-mappings>
  </prologue>
  <body>{
  "meta":{
    "className":"Robot",
    "version":9
  },
  "gizmo":{
    "parameters": [],
    "hubMappings": [{
      "meta":{
        "className":"StaticHubMapping",
        "version":2
      },
      "gizmo":{
        "id": { "string": "D2" },
        "actual": {
          "meta":{
            "className":"com.kapowtech.da.language.syntax.ProjectHubMapping",
            "version":0
          },
          "gizmo":{
            "id": { "string": "VM" }
          }
        },
        "comment": {
          "meta":{
            "className":"Comment",
            "version":0
          },
          "gizmo":{
            "comment": { "string": "" }
          }
        }
      }
    }],
    "databaseMappings": [],
    "returnTypes": [],
    "treeModes": [],
    "types": [],
    "cacheLock": {
      "meta":{
        "className":"CacheLock",
        "version":0
      },
      "gizmo":{
        
      }
    },
    "variables": [],
    "configurations": {
      "meta":{
        "className":"Configuration",
        "version":0
      },
      "gizmo":{
        "comment": {
          "meta":{
            "className":"Comment",
            "version":0
          },
          "gizmo":{
            "comment": { "string": "" }
          }
        },
        "tags": [],
        "humanProcessingTime": [],
        "icon": []
      }
    },
    "block": {
      "meta":{
        "className":"Block",
        "version":2
      },
      "gizmo":{
        "steps": [{
          "meta":{
            "className":"WindowsActionStep",
            "version":1
          },
          "gizmo":{
            "name": {
              "meta":{
                "className":"StepName",
                "version":0
              },
              "gizmo":{
                "customName": { "string": "" }
              }
            },
            "comment": {
              "meta":{
                "className":"Comment",
                "version":0
              },
              "gizmo":{
                "comment": { "string": "" }
              }
            },
            "finder": {
              "meta":{
                "className":"DeviceFinderWithName",
                "version":3
              },
              "gizmo":{
                "name": {
                  "meta":{
                    "className":"FinderName",
                    "version":0
                  },
                  "gizmo":{
                    "id": { "string": "notepad" }
                  }
                },
                "finder": {
                  "meta":{
                    "className":"DeviceReference",
                    "version":0
                  },
                  "gizmo":{
                    "reference": {
                      "meta":{
                        "className":"NamedFinderReference",
                        "version":0
                      },
                      "gizmo":{
                        "id": { "string": "D2" }
                      }
                    }
                  }
                },
                "comment": {
                  "meta":{
                    "className":"Comment",
                    "version":0
                  },
                  "gizmo":{
                    "comment": { "string": "" }
                  }
                }
              }
            },
            "config": {
              "meta":{
                "className":"ActionStepConfig",
                "version":0
              },
              "gizmo":{
                "properties": {
                  "meta":{
                    "className":"RecordDasValue",
                    "version":0
                  },
                  "gizmo":{
                    "values": [{
                      "meta":{
                        "className":"DasFieldValue",
                        "version":0
                      },
                      "gizmo":{
                        "name": { "string": "Action" },
                        "value": {
                          "meta":{
                            "className":"UnionDasValue",
                            "version":0
                          },
                          "gizmo":{
                            "id": { "string": "Execute" },
                            "value": {
                              "meta":{
                                "className":"MethodDasValue",
                                "version":0
                              },
                              "gizmo":{
                                "arguments": {
                                  "meta":{
                                    "className":"RecordDasValue",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "values": [{
                                      "meta":{
                                        "className":"DasFieldValue",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "name": { "string": "Executable" },
                                        "value": {
                                          "meta":{
                                            "className":"ExpressionDasValue",
                                            "version":0
                                          },
                                          "gizmo":{
                                            "expression": {
                                              "meta":{
                                                "className":"Expression",
                                                "version":1
                                              },
                                              "gizmo":{
                                                "text": { "string": "notepad" },
                                                "comment": {
                                                  "meta":{
                                                    "className":"Comment",
                                                    "version":0
                                                  },
                                                  "gizmo":{
                                                    "comment": { "string": "" }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    },
                                    {
                                      "meta":{
                                        "className":"DasFieldValue",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "name": { "string": "Interactive" },
                                        "value": {
                                          "meta":{
                                            "className":"ExpressionDasValue",
                                            "version":0
                                          },
                                          "gizmo":{
                                            "expression": {
                                              "meta":{
                                                "className":"Expression",
                                                "version":1
                                              },
                                              "gizmo":{
                                                "text": { "string": "false" },
                                                "comment": {
                                                  "meta":{
                                                    "className":"Comment",
                                                    "version":0
                                                  },
                                                  "gizmo":{
                                                    "comment": { "string": "" }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    },
                                    {
                                      "meta":{
                                        "className":"DasFieldValue",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "name": { "string": "Start maximized" },
                                        "value": {
                                          "meta":{
                                            "className":"ExpressionDasValue",
                                            "version":0
                                          },
                                          "gizmo":{
                                            "expression": {
                                              "meta":{
                                                "className":"Expression",
                                                "version":1
                                              },
                                              "gizmo":{
                                                "text": { "string": "true" },
                                                "comment": {
                                                  "meta":{
                                                    "className":"Comment",
                                                    "version":0
                                                  },
                                                  "gizmo":{
                                                    "comment": { "string": "" }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }]
                                  }
                                },
                                "returns": {
                                  "meta":{
                                    "className":"RecordDasValue",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "values": []
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }]
                  }
                },
                "metadata": {
                  "meta":{
                    "className":"RecordDasType",
                    "version":0
                  },
                  "gizmo":{
                    "fields": [{
                      "meta":{
                        "className":"DasField",
                        "version":2
                      },
                      "gizmo":{
                        "name": { "string": "Action" },
                        "localizationKey": { "string": "Signature.action.kAction" },
                        "optional": { "boolean": "false" },
                        "collapsible": { "boolean": "false" },
                        "typeDefinition": {
                          "meta":{
                            "className":"UnionDasType",
                            "version":0
                          },
                          "gizmo":{
                            "defaultVariantId": { "string": "Execute" },
                            "variants": [{
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Execute" },
                                "localizationKey": { "string": "Signature.windows.kExecuteAction" },
                                "id": { "string": "Execute" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Executable" },
                                            "localizationKey": { "string": "Signature.windows.kExecutableArgument" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Working Directory" },
                                            "localizationKey": { "string": "Signature.windows.kWorkingDirectoryArgument" },
                                            "optional": { "boolean": "true" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Arguments" },
                                            "localizationKey": { "string": "Signature.windows.kArgumentsArgument" },
                                            "optional": { "boolean": "true" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Interactive" },
                                            "localizationKey": { "string": "Signature.windows.kInteractiveArgument" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"BoolDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "boolean": "false" },
                                                "evaluateAtRuntime": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Start maximized" },
                                            "localizationKey": { "string": "Signature.windows.kMaximizeArgument" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"BoolDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "boolean": "true" },
                                                "evaluateAtRuntime": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": []
                                      }
                                    }
                                  }
                                }
                              }
                            }],
                            "showAsCheckbox": { "boolean": "false" }
                          }
                        }
                      }
                    }]
                  }
                }
              }
            }
          }
        },
        {
          "meta":{
            "className":"GuardedChoiceStep",
            "version":1
          },
          "gizmo":{
            "name": {
              "meta":{
                "className":"StepName",
                "version":0
              },
              "gizmo":{
                "customName": { "string": "Click Left" }
              }
            },
            "comment": {
              "meta":{
                "className":"Comment",
                "version":0
              },
              "gizmo":{
                "comment": { "string": "" }
              }
            },
            "branches": [{
              "meta":{
                "className":"GuardAndBlock",
                "version":4
              },
              "gizmo":{
                "guard": {
                  "meta":{
                    "className":"LocationFoundGuard",
                    "version":0
                  },
                  "gizmo":{
                    "finder": {
                      "meta":{
                        "className":"ComponentFinderWithName",
                        "version":9
                      },
                      "gizmo":{
                        "name": {
                          "meta":{
                            "className":"FinderName",
                            "version":0
                          },
                          "gizmo":{
                            "id": { "string": "" }
                          }
                        },
                        "finder": {
                          "meta":{
                            "className":"ComponentDescriptor",
                            "version":1
                          },
                          "gizmo":{
                            "applicationFinder": {
                              "meta":{
                                "className":"ApplicationDescriptor",
                                "version":1
                              },
                              "gizmo":{
                                "deviceFinder": {
                                  "meta":{
                                    "className":"DeviceReference",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "reference": {
                                      "meta":{
                                        "className":"NamedFinderReference",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "id": { "string": "D2" }
                                      }
                                    }
                                  }
                                },
                                "applicationSelector": {
                                  "meta":{
                                    "className":"Expression",
                                    "version":1
                                  },
                                  "gizmo":{
                                    "text": { "string": "Notepad.exe" },
                                    "comment": {
                                      "meta":{
                                        "className":"Comment",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "comment": { "string": "" }
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            "componentSelector": {
                              "meta":{
                                "className":"Expression",
                                "version":1
                              },
                              "gizmo":{
                                "text": { "string": "menu_item[name=\"File\"]" },
                                "comment": {
                                  "meta":{
                                    "className":"Comment",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "comment": { "string": "" }
                                  }
                                }
                              }
                            }
                          }
                        },
                        "comment": {
                          "meta":{
                            "className":"Comment",
                            "version":0
                          },
                          "gizmo":{
                            "comment": { "string": "" }
                          }
                        }
                      }
                    }
                  }
                },
                "block": {
                  "meta":{
                    "className":"Block",
                    "version":2
                  },
                  "gizmo":{
                    "steps": [{
                      "meta":{
                        "className":"ClickWithMoveStep",
                        "version":0
                      },
                      "gizmo":{
                        "name": {
                          "meta":{
                            "className":"StepName",
                            "version":0
                          },
                          "gizmo":{
                            "customName": { "string": "" }
                          }
                        },
                        "comment": {
                          "meta":{
                            "className":"Comment",
                            "version":0
                          },
                          "gizmo":{
                            "comment": { "string": "" }
                          }
                        },
                        "finder": {
                          "meta":{
                            "className":"ComponentFinderWithName",
                            "version":9
                          },
                          "gizmo":{
                            "name": {
                              "meta":{
                                "className":"FinderName",
                                "version":0
                              },
                              "gizmo":{
                                "id": { "string": "" }
                              }
                            },
                            "finder": {
                              "meta":{
                                "className":"ComponentReference",
                                "version":0
                              },
                              "gizmo":{
                                "reference": {
                                  "meta":{
                                    "className":"PreviousFinderReference",
                                    "version":0
                                  },
                                  "gizmo":{
                                    
                                  }
                                }
                              }
                            },
                            "comment": {
                              "meta":{
                                "className":"Comment",
                                "version":0
                              },
                              "gizmo":{
                                "comment": { "string": "" }
                              }
                            }
                          }
                        },
                        "button": {
                          "meta":{
                            "className":"FixedButton",
                            "version":0
                          },
                          "gizmo":{
                            "button": { "int": "0" }
                          }
                        },
                        "count": {
                          "meta":{
                            "className":"Expression",
                            "version":1
                          },
                          "gizmo":{
                            "text": { "string": "1" },
                            "comment": {
                              "meta":{
                                "className":"Comment",
                                "version":0
                              },
                              "gizmo":{
                                "comment": { "string": "" }
                              }
                            }
                          }
                        },
                        "modifier": {
                          "meta":{
                            "className":"FixedKeyModifier",
                            "version":0
                          },
                          "gizmo":{
                            "shift": { "boolean": "false" },
                            "ctrl": { "boolean": "false" },
                            "alt": { "boolean": "false" }
                          }
                        },
                        "offset": {
                          "meta":{
                            "className":"NoOffset",
                            "version":0
                          },
                          "gizmo":{
                            
                          }
                        }
                      }
                    }]
                  }
                },
                "comment": {
                  "meta":{
                    "className":"Comment",
                    "version":0
                  },
                  "gizmo":{
                    "comment": { "string": "" }
                  }
                }
              }
            },
            {
              "meta":{
                "className":"GuardAndBlock",
                "version":4
              },
              "gizmo":{
                "guard": {
                  "meta":{
                    "className":"TimeOutGuard",
                    "version":0
                  },
                  "gizmo":{
                    "seconds": {
                      "meta":{
                        "className":"Expression",
                        "version":1
                      },
                      "gizmo":{
                        "text": { "string": "60" },
                        "comment": {
                          "meta":{
                            "className":"Comment",
                            "version":0
                          },
                          "gizmo":{
                            "comment": { "string": "" }
                          }
                        }
                      }
                    }
                  }
                },
                "block": {
                  "meta":{
                    "className":"Block",
                    "version":2
                  },
                  "gizmo":{
                    "steps": [{
                      "meta":{
                        "className":"ThrowStep",
                        "version":1
                      },
                      "gizmo":{
                        "name": {
                          "meta":{
                            "className":"StepName",
                            "version":0
                          },
                          "gizmo":{
                            "customName": { "string": "" }
                          }
                        },
                        "comment": {
                          "meta":{
                            "className":"Comment",
                            "version":0
                          },
                          "gizmo":{
                            "comment": { "string": "" }
                          }
                        },
                        "exception": {
                          "meta":{
                            "className":"ExceptionUse",
                            "version":1
                          },
                          "gizmo":{
                            "id": { "string": "TimeOutError" },
                            "comment": {
                              "meta":{
                                "className":"Comment",
                                "version":0
                              },
                              "gizmo":{
                                "comment": { "string": "" }
                              }
                            }
                          }
                        }
                      }
                    }]
                  }
                },
                "comment": {
                  "meta":{
                    "className":"Comment",
                    "version":0
                  },
                  "gizmo":{
                    "comment": { "string": "" }
                  }
                }
              }
            }]
          }
        },
        {
          "meta":{
            "className":"PressKeyStep",
            "version":1
          },
          "gizmo":{
            "name": {
              "meta":{
                "className":"StepName",
                "version":0
              },
              "gizmo":{
                "customName": { "string": "" }
              }
            },
            "comment": {
              "meta":{
                "className":"Comment",
                "version":0
              },
              "gizmo":{
                "comment": { "string": "" }
              }
            },
            "finder": {
              "meta":{
                "className":"ApplicationFinderWithName",
                "version":6
              },
              "gizmo":{
                "name": {
                  "meta":{
                    "className":"FinderName",
                    "version":0
                  },
                  "gizmo":{
                    "id": { "string": "" }
                  }
                },
                "finder": {
                  "meta":{
                    "className":"ApplicationReference",
                    "version":1
                  },
                  "gizmo":{
                    "reference": {
                      "meta":{
                        "className":"PreviousFinderReference",
                        "version":0
                      },
                      "gizmo":{
                        
                      }
                    },
                    "comment": {
                      "meta":{
                        "className":"Comment",
                        "version":0
                      },
                      "gizmo":{
                        "comment": { "string": "" }
                      }
                    }
                  }
                },
                "comment": {
                  "meta":{
                    "className":"Comment",
                    "version":0
                  },
                  "gizmo":{
                    "comment": { "string": "" }
                  }
                }
              }
            },
            "key": {
              "meta":{
                "className":"FixedKey",
                "version":0
              },
              "gizmo":{
                "virtualKeyCode": { "string": "VK_RETURN" }
              }
            },
            "modifier": {
              "meta":{
                "className":"FixedKeyModifier",
                "version":0
              },
              "gizmo":{
                "shift": { "boolean": "false" },
                "ctrl": { "boolean": "false" },
                "alt": { "boolean": "false" }
              }
            },
            "count": {
              "meta":{
                "className":"Expression",
                "version":1
              },
              "gizmo":{
                "text": { "string": "1" },
                "comment": {
                  "meta":{
                    "className":"Comment",
                    "version":0
                  },
                  "gizmo":{
                    "comment": { "string": "" }
                  }
                }
              }
            }
          }
        },
        {
          "meta":{
            "className":"ReturnStep",
            "version":1
          },
          "gizmo":{
            "name": {
              "meta":{
                "className":"StepName",
                "version":0
              },
              "gizmo":{
                "customName": { "string": "" }
              }
            },
            "comment": {
              "meta":{
                "className":"Comment",
                "version":0
              },
              "gizmo":{
                "comment": { "string": "" }
              }
            },
            "values": []
          }
        }]
      }
    }
  }
}</body>
</object>
