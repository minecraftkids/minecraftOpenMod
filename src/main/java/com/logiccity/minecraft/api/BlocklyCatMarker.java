package com.logiccity.minecraft.api;

public interface BlocklyCatMarker {
	
	static @interface I_PlayerLocation {}
	static @interface I_PlayerRotation {}
	static @interface I_BlockInfo {}
	static @interface I_PlayerStatus {}

	static @interface C_MovePlayerStart {}
	static @interface C_MovePlayerStop {}
	static @interface C_PlayerAttack {}
	static @interface C_ChangePlayerStatus {}
	static @interface C_BuildBlocks {}
	static @interface C_ChatPrint {}
	static @interface C_CommandAccess {}
//	static @interface HelperUtils {}
}
