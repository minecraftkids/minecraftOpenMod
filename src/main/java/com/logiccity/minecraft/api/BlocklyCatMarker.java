package com.logiccity.minecraft.api;

public interface BlocklyCatMarker {
	
	static @interface I_PlayerLocation {}
	static @interface I_PlayerRotation {}
	static @interface I_BlockInfo {}
	static @interface I_GameStatus {}
	static @interface I_MovementState {}
	static @interface I_ClientStatus {}

	static @interface C_ControlKeys {}
	static @interface C_PlayerAttack {}
	static @interface C_ChangePlayerStatus {}
	static @interface C_BuildBlocks {}
	static @interface C_ChatPrint {}
	static @interface C_CommandAccess {}
	static @interface C_RenderUI {}
	static @interface C_ServerPacket {}
//	static @interface HelperUtils {}
}
